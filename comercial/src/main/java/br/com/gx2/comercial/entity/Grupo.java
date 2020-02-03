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
@Table(name="GRUPOS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {

	@Id
	@Column(name="CODIGO_GRUPO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrupo;
	
	@Column(name="DESCRICAO_GRUPO")
	private String descricaoGrupo;
}
