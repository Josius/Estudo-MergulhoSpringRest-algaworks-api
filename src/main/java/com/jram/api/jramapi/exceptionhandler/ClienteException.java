package com.jram.api.jramapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteException {
    
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
