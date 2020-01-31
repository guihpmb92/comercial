package br.com.gx2.comercial.api.DTO;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LojaDTO implements Serializable {

	private String nome;
}
