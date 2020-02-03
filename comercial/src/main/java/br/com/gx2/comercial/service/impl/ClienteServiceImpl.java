package br.com.gx2.comercial.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Cliente;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.repository.ClienteRepository;
import br.com.gx2.comercial.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {
		validaCPF(cliente.getCpf());
		return repository.save(cliente);
	}

	@Override
	public void validaCPF(String cpf) {
		if(cpf.length() != 11) {
			throw new RegraNegocioException("Cpf é inválido.");
		}
	}

	@Override
	public List<Cliente> buscarCliente(Cliente clienteFiltro) {
		Example example = Example.of(clienteFiltro, ExampleMatcher.matching());
		
		return repository.findAll(example);
	}

	@Override
	public Optional<Cliente> obterPorId(Long id) {
		return repository.findById(id);
	}
	
	

}
