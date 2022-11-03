package br.com.algaworksmaratona.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworksmaratona.model.Cliente;

@RestController
public class ClienteController {

		@GetMapping("/clientes")
		public List<Cliente> listar() {
			Cliente cliente1 = new Cliente();
			cliente1.setEmail("douglasp.alves@hotmail.com");
			cliente1.setId(1L);
			cliente1.setNome("Douglas");
			cliente1.setTelefone("11 11111-1111");
			
			
			Cliente cliente2 = new Cliente();
			cliente2.setEmail("ccarolinapina@outlook.com");
			cliente2.setId(2L);
			cliente2.setNome("Carolina");
			cliente2.setTelefone("11 11111-1111");
			
			return Arrays.asList(cliente1, cliente2);
		}
}
