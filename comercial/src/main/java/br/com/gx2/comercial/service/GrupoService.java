package br.com.gx2.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Grupo;

@Service
public interface GrupoService {

	public Grupo salvarGrupo(Grupo grupo);
	
	List<Grupo> buscarGrupo(Grupo grupoFiltro);
	
	Optional<Grupo> obterPorId(Long id);
}
