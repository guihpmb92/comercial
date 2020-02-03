package br.com.gx2.comercial.api.DTO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CupomFiscalDTO {

	private Long cupom;
	private BigDecimal valorCupom;
	private Date emissao;
	private Long loja;
	private Long cliente;
	private Long vendedor;
	
}
