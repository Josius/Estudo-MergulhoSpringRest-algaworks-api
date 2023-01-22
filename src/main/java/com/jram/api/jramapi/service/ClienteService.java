package com.jram.api.jramapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jram.api.jramapi.entitiy.Cliente;
import com.jram.api.jramapi.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    
    private ClienteRepository clienteRepository;

    @Transactional
    private Cliente salvar(Cliente cliente){

        return clienteRepository.save(cliente);
    }
}
