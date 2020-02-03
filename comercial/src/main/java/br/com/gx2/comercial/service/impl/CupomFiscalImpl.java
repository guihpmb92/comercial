package br.com.gx2.comercial.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.CupomFiscal;
import br.com.gx2.comercial.repository.CupomFiscalRepository;
import br.com.gx2.comercial.service.CupomFiscalService;

@Service
public class CupomFiscalImpl implements CupomFiscalService{

	@Autowired
	private CupomFiscalRepository repository;
	
	@Override
	public CupomFiscal salvarCupomFiscal(CupomFiscal cupomFiscal) {
		return repository.save(cupomFiscal);
	}

	@Override
	public Optional<CupomFiscal> obterPorId(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public void atualizarValorTotal(CupomFiscal cupomFiscal, BigDecimal valor) {
		BigDecimal valorAntigo = cupomFiscal.getValorCupomFiscal();
		
		BigDecimal valorAtualizado = valorAntigo.add(valor);

		cupomFiscal.setValorCupomFiscal(valorAtualizado);
		repository.save(cupomFiscal);
	}

}
