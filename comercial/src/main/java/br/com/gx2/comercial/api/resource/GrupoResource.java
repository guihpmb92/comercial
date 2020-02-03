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

import br.com.gx2.comercial.entity.Grupo;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.GrupoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
public class GrupoResource {

	@Autowired
	private final GrupoService service;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody Grupo dto) {
		Grupo grupo = Grupo.builder()
				.descricaoGrupo(dto.getDescricaoGrupo())
				.build();
		try {
			Grupo grupoSalvo = service.salvarGrupo(grupo);
			return ResponseEntity.ok(grupoSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity buscarGrupos(@RequestParam(value="descricao",required = false) String descricao) {
		Grupo grupoFiltro = new Grupo();
		
		grupoFiltro.setDescricaoGrupo(descricao);
		
		List<Grupo> grupos = service.buscarGrupo(grupoFiltro);
		
		return ResponseEntity.ok(grupos);
	}
}
