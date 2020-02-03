package br.com.gx2.comercial.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.comercial.api.DTO.LojaDTO;
import br.com.gx2.comercial.entity.Loja;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.LojaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lojas")
@RequiredArgsConstructor
public class LojaResource {

	@Autowired
	private final LojaService service;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody LojaDTO dto) {
		System.out.println(dto.toString());
		Loja loja = Loja.builder()
				.nomeLoja(dto.getNome())
				.build();
		try {
			Loja lojaSalvo = service.salvar(loja);
			return ResponseEntity.ok(lojaSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity buscarLojas(@RequestParam(value="loja", required = false) String NomeLoja) {
		Loja lojaFiltro = new Loja();
		
		lojaFiltro.setNomeLoja(NomeLoja);
		
		List<Loja> lojas = service.buscarLojas(lojaFiltro);
		
		return ResponseEntity.ok(lojas);
	}
	
}


