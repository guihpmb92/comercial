package br.com.gx2.comercial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.ItemCupomFiscal;
import br.com.gx2.comercial.repository.ItemCupomFiscalRepository;
import br.com.gx2.comercial.service.ItemCupomFiscalService;

@Service
public class ItemCupomFiscalImpl implements ItemCupomFiscalService {

	@Autowired
	private ItemCupomFiscalRepository repository;
	
	@Override
	public ItemCupomFiscal salvarCupomFiscal(ItemCupomFiscal itemCupomFiscal) {
		return repository.save(itemCupomFiscal);
	}

}
