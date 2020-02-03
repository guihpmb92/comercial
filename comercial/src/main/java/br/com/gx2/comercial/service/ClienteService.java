package br.com.gx2.comercial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Cliente;

@Service
public interface ClienteService {

	public Cliente salvar(Cliente cliente);
	
	public void validaCPF(String cpf);
	
	List<Cliente> buscarCliente(Cliente clienteFiltro);
	
	Optional<Cliente> obterPorId(Long id);
	
}
