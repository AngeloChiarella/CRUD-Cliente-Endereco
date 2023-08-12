package br.com.crud.cliente.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.cliente.entities.Cliente;
import br.com.crud.cliente.entities.dtos.ClienteDto;
import br.com.crud.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ConverterMapper converter;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDto> findAll() { 
		return clienteRepository.findAll()
				.stream()
				.map(converter::clienteToDto)
				.sorted(Comparator.comparing(ClienteDto::getNome))
				.collect(Collectors.toList());
	}

	public List<ClienteDto> findByNomeDto(String nome) {
		return clienteRepository.findByNomeDto(nome)
				.stream()
				.map(converter::clienteToDto)
				.collect(Collectors.toList());
	}

	public void saveOrUpdate(ClienteDto cliente) {
		clienteRepository.save(converter.dtoToCliente(cliente));
	}

	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

}
