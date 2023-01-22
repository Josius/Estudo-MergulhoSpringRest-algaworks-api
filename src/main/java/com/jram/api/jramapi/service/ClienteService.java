package com.jram.api.jramapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jram.api.jramapi.entitiy.Cliente;
import com.jram.api.jramapi.exception.NegocioException;
import com.jram.api.jramapi.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
    
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){

        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
        .stream()
        .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail!");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clientId){
        
        clienteRepository.deleteById(clientId);
    }

    @Transactional
    public List<Cliente> buscarTodosOsClientes(){
        
        return clienteRepository.findAll();
    }
    
    @Transactional
    public Optional<Cliente> buscarUmClientePorId(Long clienteId){

        return clienteRepository.findById(clienteId);
    }
}
