package br.com.gx2.comercial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.Loja;

@Service
public interface LojaService {
	
	public Loja salvar(Loja loja); 
	
	List<Loja> buscarLojas(Loja lojaFiltro);
}
