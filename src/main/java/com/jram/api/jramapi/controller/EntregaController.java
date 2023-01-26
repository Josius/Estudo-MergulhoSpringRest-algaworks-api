package com.jram.api.jramapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jram.api.jramapi.DTOs.EntregaDTO;
import com.jram.api.jramapi.DTOs.input.EntregaInputDTO;
import com.jram.api.jramapi.assembler.EntregaAssembler;
import com.jram.api.jramapi.entitiy.Entrega;
import com.jram.api.jramapi.repository.EntregaRepository;
import com.jram.api.jramapi.service.EntregaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    
    private EntregaRepository entregaRepository;
    private EntregaService entregaService;
    private EntregaAssembler entregaAssembler;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitarEntrega(@Valid @RequestBody EntregaInputDTO  entregaInputDTO){
        
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInputDTO);

        return entregaAssembler.toDTO(entregaService.solicitarEntrega(novaEntrega));
    }

    @GetMapping
    public List<EntregaDTO> listar(){
        
        return entregaAssembler.toCollectionDTO(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){

        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toDTO(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
