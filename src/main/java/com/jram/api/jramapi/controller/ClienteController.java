package com.jram.api.jramapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jram.api.jramapi.entitiy.Cliente;

@RestController
public class ClienteController {
    
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setNome("nome umD");
        c1.setTelefone("113333");
        c1.setEmail("c1@email.com");
        
        Cliente c2 = new Cliente();
        c2.setId(2L);
        c2.setNome("nome dois");
        c2.setTelefone("11333355");
        c2.setEmail("c2@email.com");

        return Arrays.asList(c1, c2);
    }
}
