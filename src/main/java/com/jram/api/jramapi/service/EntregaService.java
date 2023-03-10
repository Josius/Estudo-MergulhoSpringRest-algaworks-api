package com.jram.api.jramapi.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jram.api.jramapi.entitiy.Cliente;
import com.jram.api.jramapi.entitiy.Entrega;
import com.jram.api.jramapi.entitiy.StatusEntrega;
import com.jram.api.jramapi.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {
    
    private ClienteService clienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitarEntrega(Entrega entrega){

        Cliente cliente = clienteService.buscarCliente(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
