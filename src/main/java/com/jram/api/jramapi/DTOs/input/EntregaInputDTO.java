package com.jram.api.jramapi.DTOs.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.jram.api.jramapi.entitiy.Destinatario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputDTO {
    
    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private DestinatarioInput destinatario;
    
    @NotNull
    private BigDecimal taxa;
}
