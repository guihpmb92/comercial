package br.com.gx2.comercial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Grupo;
import br.com.gx2.comercial.repository.GruposRepository;
import br.com.gx2.comercial.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{

	@Autowired
	private GruposRepository repository;

	@Override
	public Grupo salvarGrupo(Grupo grupo) {
		return repository.save(grupo);
	}

	@Override
	public List<Grupo> buscarGrupo(Grupo grupoFiltro) {
		Example example = Example.of(grupoFiltro, ExampleMatcher.matching());
		
		return repository.findAll(example);
	}

	@Override
	public Optional<Grupo> obterPorId(Long id) {
		return repository.findById(id);
	}
	
	
}
