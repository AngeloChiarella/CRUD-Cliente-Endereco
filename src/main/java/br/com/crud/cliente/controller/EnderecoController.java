package br.com.crud.cliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.cliente.entities.Endereco;
import br.com.crud.cliente.entities.dtos.EnderecoDto;
import br.com.crud.cliente.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoDto>> findAll() {
		List<EnderecoDto> list = enderecoService.findAll();
		if (list.isEmpty())
			return new ResponseEntity<List<EnderecoDto>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<EnderecoDto>>(list, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Endereco>> findById(@PathVariable Long id) {
		Optional<Endereco> cliente = enderecoService.findById(id);
		if (cliente.isPresent())
			return new ResponseEntity<Optional<Endereco>>(cliente, HttpStatus.OK);
		
		return new ResponseEntity<Optional<Endereco>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/nomeCliente/{nome}")
	public ResponseEntity<List<EnderecoDto>> findByNomeCliente(@PathVariable String nome) {
		List<EnderecoDto> list = enderecoService.findByNomeCliente(nome);
		if (list.isEmpty())
			return new ResponseEntity<List<EnderecoDto>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<EnderecoDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/clienteId/{id}")
	public ResponseEntity<List<EnderecoDto>> findByIdCliente(@PathVariable Long id) {
		List<EnderecoDto> list = enderecoService.findByClienteId(id);
		if (list.isEmpty())
			return new ResponseEntity<List<EnderecoDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<EnderecoDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/nomeRua/{nome}")
	public ResponseEntity<List<EnderecoDto>> findByNomeRua(@PathVariable String nome) {
		List<EnderecoDto> list = enderecoService.findByNomeRua(nome);
		if (list.isEmpty())
			return new ResponseEntity<List<EnderecoDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<EnderecoDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/uf/{uf}")
	public ResponseEntity<List<EnderecoDto>> findByUf(@PathVariable String uf) {
		List<EnderecoDto> list = enderecoService.findByUf(uf);
		if (list.isEmpty())
			return new ResponseEntity<List<EnderecoDto>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<EnderecoDto>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody EnderecoDto dto) {
		try {
			enderecoService.saveOrUpdate(dto);
			return new ResponseEntity<String>("Criado com sucesso!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody EnderecoDto dto, @PathVariable Long id) {
		if (findById(id).getBody().isPresent())
			dto.setId(id);
		
		enderecoService.saveOrUpdate(dto);
		return new ResponseEntity<String>("Alterado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if (findById(id).getBody() != null) {
			enderecoService.deleteById(id);
			return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
