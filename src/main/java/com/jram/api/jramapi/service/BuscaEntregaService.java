package com.jram.api.jramapi.service;

import org.springframework.stereotype.Service;

import com.jram.api.jramapi.entitiy.Entrega;
import com.jram.api.jramapi.exception.EntidadeNaoEncontradaException;
import com.jram.api.jramapi.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
    
    private EntregaRepository entregaRepository;
    
    public Entrega buscar(Long entregaId){

        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
