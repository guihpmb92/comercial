package br.com.gx2.comercial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Loja;
import br.com.gx2.comercial.repository.LojaRepository;
import br.com.gx2.comercial.service.LojaService;

@Service
public class LojaServiceImpl implements LojaService{
	
	@Autowired
	private LojaRepository repository;

	public Loja salvar(Loja loja) {
		return repository.save(loja);
	}

	@Override
	public List<Loja> buscarLojas(Loja lojaFiltro) {
		Example example = Example.of(lojaFiltro, ExampleMatcher.matching().withIgnoreCase());
		
		return repository.findAll(example);
	}

}
