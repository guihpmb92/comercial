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
@Table(name="CLIENTES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@Column(name="CODIGO_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME_CLIENTE")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
}
