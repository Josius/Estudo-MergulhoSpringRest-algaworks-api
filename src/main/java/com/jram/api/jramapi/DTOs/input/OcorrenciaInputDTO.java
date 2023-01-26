package com.jram.api.jramapi.DTOs.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInputDTO {
    
    @NotBlank
    private String descricao;
}
