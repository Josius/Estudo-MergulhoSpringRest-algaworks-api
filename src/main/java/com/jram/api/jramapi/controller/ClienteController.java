package com.jram.api.jramapi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jram.api.jramapi.entitiy.Cliente;
import com.jram.api.jramapi.repository.ClienteRepository;
import com.jram.api.jramapi.service.ClienteService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {
	
	// @Autowired
	private ClienteRepository clienteRepository;

	private ClienteService clienteService;

	
	// public ClienteController(ClienteRepository clienteRepository) {
	//     this.clienteRepository = clienteRepository;
	// }


	@GetMapping
	public List<Cliente> listar(){
		
		return clienteService.buscarTodosOsClientes();
		// return clienteRepository.findByNomeContaining("o");
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
		
		return clienteService.buscarUmClientePorId(clienteId)
				// .map(cliente -> ResponseEntity.ok(cliente))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

		// Optional<Cliente> cliente =  clienteRepository.findById(clienteId);

		// if(cliente.isPresent()){
		//     return ResponseEntity.ok(cliente.get());
		// }
		// return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente){
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){
		
		if(!clienteRepository.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = clienteService.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){

		if(!clienteRepository.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}

		clienteService.excluir(clienteId);

		return ResponseEntity.noContent().build();
	}
}
