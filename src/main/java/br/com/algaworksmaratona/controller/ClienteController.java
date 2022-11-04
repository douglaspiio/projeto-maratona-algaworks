package br.com.algaworksmaratona.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworksmaratona.model.Cliente;
import br.com.algaworksmaratona.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
	
	private ClienteRepository clienteRepository;

		@GetMapping("/clientes")
		public List<Cliente> listar() {
			return clienteRepository.findAll();
			
		}
}
