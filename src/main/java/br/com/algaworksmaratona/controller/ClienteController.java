package br.com.algaworksmaratona.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.algaworksmaratona.model.Cliente;
import br.com.algaworksmaratona.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
		public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
			return clienteRepository.findById(id)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
			
//			Optional<Cliente> cliente = clienteRepository.findById(id);
//			if(cliente.isPresent()){
//				return ResponseEntity.ok(cliente.get());
//			}
//			return ResponseEntity.notFound().build();
		}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		Cliente clienteSave = clienteRepository.save(cliente);
		return ResponseEntity.ok(clienteSave);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
			}
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
}
