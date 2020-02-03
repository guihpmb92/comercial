package br.com.gx2.comercial.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gx2.comercial.entity.CupomFiscal;

@Service
public interface CupomFiscalService {

	public CupomFiscal salvarCupomFiscal(CupomFiscal cupomFiscal);
	
	Optional<CupomFiscal> obterPorId(Long id);
	
	public void atualizarValorTotal(CupomFiscal cupomFiscal, BigDecimal valor);
}
