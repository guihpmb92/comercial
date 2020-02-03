package br.com.gx2.comercial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Vendedor;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.repository.VendedorRepository;
import br.com.gx2.comercial.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository repository;
	private Example example;
	
	@Override
	public Vendedor salvarVendedor(Vendedor vendedor) {
		//validarMatricula(vendedor.getMatricula());
		return repository.save(vendedor);
	}

	@Override
	public List<Vendedor> buscarVendedor(Vendedor vendedorFiltro) {
		example = Example.of(vendedorFiltro, ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}

	@Override
	public Optional<Vendedor> obterPorId(Long id) {
		return repository.findById(id);
	}

}
