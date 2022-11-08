package br.com.algaworksmaratona.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	
	@AllArgsConstructor
	@Getter
	public static class Campo{
		private String nome;
		private String mensagem;
	}

}
