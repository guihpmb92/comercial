package br.com.gx2.comercial.api.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {

	private String ncm;
	private String produto;
	private Long grupo;
}
