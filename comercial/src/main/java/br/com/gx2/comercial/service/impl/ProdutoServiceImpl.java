package br.com.gx2.comercial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Produto;
import br.com.gx2.comercial.repository.ProdutoRepository;
import br.com.gx2.comercial.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Produto salvarProduto(Produto produto) {

		return repository.save(produto); 
	}

	@Override
	public List<Produto> buscaProduto(Produto produtoFiltro) {
		Example example = Example.of(produtoFiltro, ExampleMatcher.matching());

		return repository.findAll(example);
	}

	@Override
	public Optional<Produto> obterPorId(Long id) {
		return repository.findById(id);
	}

}
