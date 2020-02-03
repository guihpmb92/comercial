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

import br.com.gx2.comercial.api.DTO.VendedorDTO;
import br.com.gx2.comercial.entity.Vendedor;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.VendedorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedorResource {

	@Autowired
	private final VendedorService service;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody VendedorDTO dto) {
		Vendedor vendedor = Vendedor.builder()
				.nome(dto.getNome())
				.matricula(dto.getMatricula())
				.build();
		try {
			Vendedor vendedorSalvo = service.salvarVendedor(vendedor);
			return ResponseEntity.ok(vendedorSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity buscarVendedor(@RequestParam(value="matricula", required = false) String matricula) {
		Vendedor vendedorFiltro = new Vendedor();
		
		vendedorFiltro.setMatricula(matricula);
		
		List<Vendedor> vendedores = service.buscarVendedor(vendedorFiltro);
		
		return ResponseEntity.ok(vendedores);
	}
	
}
