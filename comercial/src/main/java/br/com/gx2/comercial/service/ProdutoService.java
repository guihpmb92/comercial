package br.com.gx2.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Produto;

@Service
public interface ProdutoService {

	public Produto salvarProduto(Produto produto);
	
	List<Produto> buscaProduto(Produto produtoFiltro);
	
	Optional<Produto> obterPorId(Long id);
}
