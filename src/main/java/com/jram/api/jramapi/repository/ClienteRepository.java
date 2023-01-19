package com.jram.api.jramapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jram.api.jramapi.entitiy.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome); //usa o like do SQL
}
