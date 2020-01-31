package br.com.gx2.comercial.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		Loja loja = Loja.builder().nome(dto.getNome()).build();
		try {
			Loja lojaSalva = service.salvar(loja);
			System.out.println(lojaSalva.toString());
			return new ResponseEntity(lojaSalva,HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity buscarLojas(@RequestParam (value = "loja", required = false) String loja) {
		Loja lojaFiltro = new Loja();
		lojaFiltro.setNome(loja);
		
		List<Loja> lojas = service.buscarLojas(lojaFiltro);
		
		return ResponseEntity.ok(lojas);
		
	}
	
}
