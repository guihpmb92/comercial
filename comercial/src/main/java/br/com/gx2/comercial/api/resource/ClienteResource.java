package br.com.gx2.comercial.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.comercial.api.DTO.ClienteDTO;
import br.com.gx2.comercial.entity.Cliente;
import br.com.gx2.comercial.exception.RegraNegocioException;
import br.com.gx2.comercial.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteResource {

	@Autowired
	private final ClienteService service;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody ClienteDTO dto) {
		Cliente cliente = Cliente.builder()
				.nome(dto.getNome())
				.cpf(dto.getCpf())
				.build();
		try {
			Cliente clienteSalvo = service.salvar(cliente);
			return ResponseEntity.ok(clienteSalvo);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity buscar(@RequestParam (value = "cpf", required = false) String cpf) {
		Cliente clienteFiltro = new Cliente();
		
		clienteFiltro.setCpf(cpf);
		
		List<Cliente> clientes = service.buscarCliente(clienteFiltro);
		
		return ResponseEntity.ok(clientes);
		
	}
	
}
