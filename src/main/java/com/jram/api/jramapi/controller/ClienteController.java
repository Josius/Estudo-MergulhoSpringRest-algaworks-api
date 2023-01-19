package com.jram.api.jramapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jram.api.jramapi.entitiy.Cliente;
import com.jram.api.jramapi.repository.ClienteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
    
    // @Autowired
    private ClienteRepository clienteRepository;

    
    // public ClienteController(ClienteRepository clienteRepository) {
    //     this.clienteRepository = clienteRepository;
    // }


    @GetMapping("/clientes")
    public List<Cliente> listar(){
        
        return clienteRepository.findAll();
        // return clienteRepository.findByNomeContaining("o");
    }
}
