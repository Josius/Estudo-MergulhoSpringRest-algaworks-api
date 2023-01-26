package com.jram.api.jramapi.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.jram.api.jramapi.DTOs.OcorrenciaDTO;
import com.jram.api.jramapi.entitiy.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
    
    private ModelMapper modelMapper;

    public OcorrenciaDTO toDTO(Ocorrencia ocorrencia){

        return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias){

        return ocorrencias.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
