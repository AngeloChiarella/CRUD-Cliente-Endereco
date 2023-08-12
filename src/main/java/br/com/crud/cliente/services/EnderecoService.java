package br.com.crud.cliente.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.cliente.entities.Cliente;
import br.com.crud.cliente.entities.Endereco;
import br.com.crud.cliente.entities.dtos.EnderecoDto;
import br.com.crud.cliente.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private ConverterMapper converter;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Optional<Endereco> findById(Long id) {
		return enderecoRepository.findById(id);
	}

	public List<EnderecoDto> findAll() {
		return enderecoRepository.findAll()
				.stream()
				.map(converter::enderecoToDto)
				.sorted(Comparator.comparing(EnderecoDto::getLogradouro))
				.collect(Collectors.toList());
	}

	public List<EnderecoDto> findByNomeCliente(String nome) {
		return enderecoRepository.findByNomeCliente(nome)
				.stream()
				.map(converter::enderecoToDto)
				.collect(Collectors.toList());
	}

	public List<EnderecoDto> findByNomeRua(String logradouro) {
		return enderecoRepository.findByNomeRua(logradouro)
				.stream()
				.map(converter::enderecoToDto)
				.collect(Collectors.toList());
	}

	public void saveOrUpdate(EnderecoDto dto) {
		Optional<Cliente> findById = clienteService.findById(dto.getClienteId());
		dto.setCliente(findById.get());
		enderecoRepository.save(converter.dtoToEndereco(dto));
	}

	public void deleteById(Long id) {
		enderecoRepository.deleteById(id);		
	}

	public List<EnderecoDto> findByClienteId(Long id) {
		return enderecoRepository.findByClienteId(id)
				.stream()
				.map(converter::enderecoToDto)
				.collect(Collectors.toList());
	}

	public List<EnderecoDto> findByUf(String uf) {
		return enderecoRepository.findByUf(uf)
				.stream()
				.map(converter::enderecoToDto)
				.collect(Collectors.toList());
	}

}
