package br.com.gx2.comercial.entity;

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
@Table(name="PRODUTOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Produto {

	@Column(name="CODIGO_PRODUTO")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@Column(name="NCM")
	private String ncmProduto;
	
	@Column(name="DESCRICAO")
	private String descricaoProduto;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_GRUPO")
	private Grupo grupo;
}
