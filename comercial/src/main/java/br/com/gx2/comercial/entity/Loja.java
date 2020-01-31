package br.com.gx2.comercial.entity;

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
@Table(name="LOJAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loja {

	@Id
	@Column(name="CODIGO_LOJA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NOME_LOJA")
	private String nome;
}
