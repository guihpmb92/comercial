package br.com.gx2.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Vendedor;

@Service
public interface VendedorService {

	public Vendedor salvarVendedor(Vendedor vendedor);
	
	List<Vendedor> buscarVendedor(Vendedor vendedorFiltro);
	
	Optional<Vendedor> obterPorId(Long id);
	
}
