package br.com.gx2.comercial.service;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.ItemCupomFiscal;

@Service
public interface ItemCupomFiscalService {
	
	public ItemCupomFiscal salvarCupomFiscal(ItemCupomFiscal itemCupomFiscal);
}
