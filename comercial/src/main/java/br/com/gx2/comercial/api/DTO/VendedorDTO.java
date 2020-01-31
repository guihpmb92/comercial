package br.com.gx2.comercial.api.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VendedorDTO {

	private String matricula;
	private String nome;
}
