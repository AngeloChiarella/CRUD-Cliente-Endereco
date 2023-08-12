package br.com.crud.cliente.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.cliente.entities.Cliente;
import br.com.crud.cliente.entities.Endereco;
import br.com.crud.cliente.entities.dtos.ClienteDto;
import br.com.crud.cliente.entities.dtos.EnderecoDto;

@Service
public class ConverterMapper {

	@Autowired
	private ModelMapper mapper;
	
/************************CLIENTE*********************/

	public Cliente dtoToCliente(ClienteDto dto) {
		return mapper.map(dto, Cliente.class);
	}
	
	public ClienteDto clienteToDto(Cliente cliente) {
		return mapper.map(cliente, ClienteDto.class);
	}

/************************CLIENTE*********************/
	
	public Endereco dtoToEndereco(EnderecoDto dto) {
		return mapper.map(dto, Endereco.class);
	}
	
	public EnderecoDto enderecoToDto(Endereco endereco) {
		return mapper.map(endereco, EnderecoDto.class);
	}

	
	
	
}
