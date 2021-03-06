package br.com.gx2.comercial.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LOJAS")
public class Loja implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_LOJA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoja;
	
	@Column(name="NOME_LOJA")
	private String nomeLoja;
}
