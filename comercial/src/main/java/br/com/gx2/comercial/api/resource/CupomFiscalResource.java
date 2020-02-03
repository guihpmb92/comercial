package br.com.gx2.comercial.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.comercial.api.DTO.CupomFiscalDTO;
import br.com.gx2.comercial.entity.Cliente;
import br.com.gx2.comercial.entity.CupomFiscal;
import br.com.gx2.comercial.entity.Loja;
import br.com.gx2.comercial.entity.Produto;
import br.com.gx2.comercial.entity.Vendedor;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.ClienteService;
import br.com.gx2.comercial.service.CupomFiscalService;
import br.com.gx2.comercial.service.LojaService;
import br.com.gx2.comercial.service.VendedorService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/cuponsfiscais")
@RestController
@RequiredArgsConstructor
public class CupomFiscalResource {
	
	@Autowired
	private final CupomFiscalService service;
	private final LojaService lojaService;
	private final ClienteService clienteService;
	private final VendedorService vendedorService;
	
	@RequestMapping("/salvar")
	public ResponseEntity salvarCupomFiscal(@RequestBody CupomFiscalDTO dto) {
		try {
			CupomFiscal cupomFiscalSalvo = converter(dto);
			cupomFiscalSalvo = service.salvarCupomFiscal(cupomFiscalSalvo);
			return ResponseEntity.ok(cupomFiscalSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	public CupomFiscal converter(CupomFiscalDTO dto) {
		CupomFiscal cupomFiscal = new CupomFiscal();
		
		cupomFiscal.setIdCupomFiscal(dto.getCupom());
		cupomFiscal.setValorCupomFiscal(dto.getValorCupom());
		cupomFiscal.setDataCadastro(dto.getEmissao());
		System.out.println(dto.getEmissao().toString());
		
		Loja loja = lojaService.obterPorId(dto.getLoja())
				.orElseThrow(() -> new RegraNegocioException("Loja não encontrada."));
		
		cupomFiscal.setLoja(loja);
		
		Cliente cliente = clienteService.obterPorId(dto.getCliente())
				.orElseThrow( () -> new RegraNegocioException("Cliente não encotrado."));
		//TO DO MELHORIA PARA CRIAR CLIENTE CASO NAO ENCONTRE
		
		cupomFiscal.setCliente(cliente);
		
		Vendedor vendedor = vendedorService.obterPorId(dto.getVendedor())
				.orElseThrow( () -> new RegraNegocioException("Vendedor não encontrado."));
		
		cupomFiscal.setVendedor(vendedor);
		
		return cupomFiscal;
	}

}
