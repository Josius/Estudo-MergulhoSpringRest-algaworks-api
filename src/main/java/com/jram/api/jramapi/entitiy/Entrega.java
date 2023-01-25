package com.jram.api.jramapi.entitiy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.jram.api.jramapi.validationgroups.ValidationGroups;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid 
    @ConvertGroup(to = ValidationGroups.ClienteId.class)
    // @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class) NÃO USAR O from
    @NotNull
    @ManyToOne
    private Cliente cliente;
    
    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;
    
    @NotNull
    private BigDecimal taxa;
    
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = Access.READ_ONLY)
    private StatusEntrega status;
    
    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataPedido;
    
    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;

}
