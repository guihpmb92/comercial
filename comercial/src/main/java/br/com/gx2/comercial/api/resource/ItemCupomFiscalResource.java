package br.com.gx2.comercial.api.resource;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.comercial.api.DTO.ItemCupomFiscalDTO;
import br.com.gx2.comercial.entity.CupomFiscal;
import br.com.gx2.comercial.entity.ItemCupomFiscal;
import br.com.gx2.comercial.entity.Produto;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.CupomFiscalService;
import br.com.gx2.comercial.service.ItemCupomFiscalService;
import br.com.gx2.comercial.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/itemcupomfiscal")
@RequiredArgsConstructor
public class ItemCupomFiscalResource {

	@Autowired
	private final ItemCupomFiscalService service;
	private final ProdutoService serviceProduto;
	private final CupomFiscalService serviceCupomFiscal;
	
	@RequestMapping("/salvar")
	public ResponseEntity salvarItemCupom(@RequestBody ItemCupomFiscalDTO dto) {
		try {
			ItemCupomFiscal itemCupomFiscalSalvo = converter(dto);
			itemCupomFiscalSalvo = service.salvarCupomFiscal(itemCupomFiscalSalvo);
			
			BigDecimal valorTotal = dto.getValorUnitario();
			BigDecimal qtd = dto.getQuantidade();
			
			valorTotal = valorTotal.multiply(qtd);
			
			CupomFiscal cupomFiscal = serviceCupomFiscal.obterPorId(dto.getCupom())
					.orElseThrow(() -> new RegraNegocioException("Cupom fiscal inválido."));
			
			serviceCupomFiscal.atualizarValorTotal(cupomFiscal, valorTotal);
			return ResponseEntity.ok(itemCupomFiscalSalvo);
		} catch (RegraNegocioException e ) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	public ItemCupomFiscal converter(ItemCupomFiscalDTO dto) {
		ItemCupomFiscal itemCupomFiscal = new ItemCupomFiscal();
		
		itemCupomFiscal.setQuantidadeItem(dto.getQuantidade());
		itemCupomFiscal.setValorUnitarioItem(dto.getValorUnitario());
		
		CupomFiscal cupomFiscal = serviceCupomFiscal.obterPorId(dto.getCupom())
				.orElseThrow( () -> new RegraNegocioException("Cupom não encontrado."));
		
		Produto produto = serviceProduto.obterPorId(dto.getProduto())
				.orElseThrow( () -> new RegraNegocioException("Produto não encontrado."));
		
		
		itemCupomFiscal.setCupom(cupomFiscal);
		itemCupomFiscal.setProduto(produto);
		
		return itemCupomFiscal;
	}
}
