package br.com.gx2.comercial.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ITENS_CUPOM_FISCAL")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemCupomFiscal {

	@Id
	@Column(name="CODIGO_ITEM_CUPOM_FISCAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	@Column(name="QUANTIDADE")
	private BigDecimal quantidadeItem;
	
	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitarioItem;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_PRODUTO")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_CUPOM")
	private CupomFiscal cupom;
}
