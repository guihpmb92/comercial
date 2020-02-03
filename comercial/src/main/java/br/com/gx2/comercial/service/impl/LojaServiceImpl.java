package br.com.gx2.comercial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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
		Example example = Example.of(lojaFiltro, ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
			
			return repository.findAll(example);
	}

	@Override
	public Optional<Loja> obterPorId(Long id) {
		return repository.findById(id);
	}
}
