package com.jram.api.jramapi.DTOs;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.jram.api.jramapi.entitiy.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {
    
    private Long id;
    private String nomeCliente;
    private DestinatarioDTO destinatarioDTO;
    private BigDecimal taxa;
    private StatusEntrega statusEntrega;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
