package com.jram.api.jramapi.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ClienteException {
    
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
