package br.com.gx2.comercial.api.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LojaDTO {

	private Long id;
	private String nome;
}
