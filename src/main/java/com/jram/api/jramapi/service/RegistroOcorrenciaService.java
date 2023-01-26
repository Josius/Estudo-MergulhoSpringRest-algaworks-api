package com.jram.api.jramapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jram.api.jramapi.entitiy.Entrega;
import com.jram.api.jramapi.entitiy.Ocorrencia;
import com.jram.api.jramapi.exception.NegocioException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
    
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){

        Entrega entrega = buscaEntregaService.buscar(entregaId);
        
        return entrega.adicionarOcorrencia(descricao);
    }
}
