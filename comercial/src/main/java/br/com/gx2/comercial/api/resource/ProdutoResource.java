package br.com.gx2.comercial.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.comercial.api.DTO.ProdutoDTO;
import br.com.gx2.comercial.entity.Grupo;
import br.com.gx2.comercial.entity.Produto;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.GrupoService;
import br.com.gx2.comercial.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/produtos")
@RequiredArgsConstructor
@RestController
public class ProdutoResource {

	@Autowired
	private final ProdutoService service;
	private final GrupoService grupoService;
	
	@RequestMapping("/salvar")
	public ResponseEntity salvarProduto(@RequestBody ProdutoDTO dto) {
		try {
			Produto produtoSalvo = converter(dto);
			produtoSalvo = service.salvarProduto(produtoSalvo);
			
			return ResponseEntity.ok(produtoSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity buscarProduto(
					@RequestParam(value="descricao",required = false) String descricao,
					@RequestParam(value="grupo", required = false) Long grupoId) {
		
		Produto produtoFiltro = new Produto();
		
		produtoFiltro.setDescricaoProduto(descricao);
		
		Optional<Grupo> grupo = grupoService.obterPorId(grupoId);
		if(!grupo.isPresent()) {
			return ResponseEntity.badRequest().body("Não foi possivel realizar a pesquisa, Grupo não encontrado.");
		}else {
			produtoFiltro.setGrupo(grupo.get());
		}
		
		List<Produto> produtos = service.buscaProduto(produtoFiltro);
		
		return ResponseEntity.ok(produtos);
	}
	
	private Produto converter(ProdutoDTO dto) {
		Produto produto = new Produto();
		
		produto.setNcmProduto(dto.getNcm());
		produto.setDescricaoProduto(dto.getProduto());
		
		Grupo grupo = grupoService.obterPorId(dto.getGrupo())
				.orElseThrow( () -> new RegraNegocioException("Grupo não encontrado."));
		
		produto.setGrupo(grupo);
		
		return produto;
	}
	
}
