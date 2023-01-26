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
    private ClienteDTO cliente;
    private DestinatarioDTO destinatario;
    private BigDecimal taxa;
    private StatusEntrega statusEntrega;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
    
}

/* Curioso, na classe Entrega, não é nomeCliente, e sim Cliente cliente, e no caso, ele pegou o nome do cliente.
Já no caso do DestinatarioDTO, o nome precisa ser o mesmo que consta na classe, do contrário, retorna null.
*/