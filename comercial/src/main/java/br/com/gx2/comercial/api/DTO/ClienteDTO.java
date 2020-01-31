package br.com.gx2.comercial.api.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDTO {

	private String nome;
	private String cpf;
	
}
