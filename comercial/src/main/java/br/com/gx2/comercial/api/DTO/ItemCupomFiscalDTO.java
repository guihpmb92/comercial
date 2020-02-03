package br.com.gx2.comercial.api.DTO;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemCupomFiscalDTO {

	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private Long produto;
	private Long cupom;
}
