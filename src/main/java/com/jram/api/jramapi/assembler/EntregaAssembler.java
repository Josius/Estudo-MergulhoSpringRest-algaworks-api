package com.jram.api.jramapi.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.jram.api.jramapi.DTOs.EntregaDTO;
import com.jram.api.jramapi.DTOs.input.EntregaInputDTO;
import com.jram.api.jramapi.entitiy.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
    
    private ModelMapper modelMapper;

    public EntregaDTO toDTO(Entrega entrega){

        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionDTO(List<Entrega> entregas){
        
        return entregas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInputDTO entregaInputDTO){

        return modelMapper.map(entregaInputDTO, Entrega.class);
    }
}
