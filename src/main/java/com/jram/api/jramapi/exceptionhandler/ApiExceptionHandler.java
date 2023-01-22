package com.jram.api.jramapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jram.api.jramapi.exception.NegocioException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
    
    private MessageSource messageSource;

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        
        List<Campo> campos = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError)error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new Campo(nome, mensagem));
        }
        ClienteException clienteException = new ClienteException();
        clienteException.setStatus(status.value());
        clienteException.setDataHora(LocalDateTime.now());
        clienteException.setTitulo("Um ou mais campos estão inválidos! Faça o preenchimento correto, e tente novamente.");
        clienteException.setCampos(campos);
        
        return handleExceptionInternal(ex, clienteException, headers, status, request); 
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException negocioException, WebRequest request){

        HttpStatus status =  HttpStatus.BAD_REQUEST;

        ClienteException clienteException = new ClienteException();
        clienteException.setStatus(status.value());
        clienteException.setDataHora(LocalDateTime.now());
        clienteException.setTitulo(negocioException.getMessage());
        
        return handleExceptionInternal(negocioException, clienteException, new HttpHeaders(), status, request);
    }

}
