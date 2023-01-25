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

import com.jram.api.jramapi.DTOs.DestinatarioDTO;
import com.jram.api.jramapi.DTOs.EntregaDTO;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntrega(@Valid @RequestBody Entrega entrega){

        return entregaService.solicitarEntrega(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId){

        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDTO entregaDTO = new EntregaDTO();
                    entregaDTO.setId(entrega.getId());
                    entregaDTO.setNomeCliente(entrega.getCliente().getNome());
                    entregaDTO.setDestinatarioDTO(new DestinatarioDTO());
                    entregaDTO.getDestinatarioDTO().setNome(entrega.getDestinatario().getNome());
                    entregaDTO.getDestinatarioDTO().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaDTO.getDestinatarioDTO().setNumero(entrega.getDestinatario().getNumero());
                    entregaDTO.getDestinatarioDTO().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaDTO.getDestinatarioDTO().setBairro(entrega.getDestinatario().getBairro());
                    entregaDTO.setTaxa(entrega.getTaxa());
                    entregaDTO.setStatusEntrega(entrega.getStatus());
                    entregaDTO.setDataPedido(entrega.getDataPedido());
                    entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
