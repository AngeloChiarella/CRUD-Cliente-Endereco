package br.com.crud.cliente.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;

import br.com.crud.cliente.entities.Cliente;
import br.com.crud.cliente.entities.Endereco;
import br.com.crud.cliente.repositories.ClienteRepository;
import br.com.crud.cliente.repositories.EnderecoRepository;

@Configuration
@SpringBootConfiguration
public class PopulateDatabase implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente("Angelo Chiarella", "chiarella@email.com", "438.550.928-00");
		Cliente c2 = new Cliente("Silvio Santos", "silvio.santos@email.com", "163.797.350-03");
		Cliente c3 = new Cliente("Pablo Marçal", "pablo.marcal@email.com", "399.721.880-35");
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));

		Endereco e1 = new Endereco(c1, "Centro", "Rua A", 12345678, 552, "São Paulo", "SP");                           
		Endereco e2 = new Endereco(c1, "Itaim Bibi", "Rua D", 45678901, 654, "São Paulo", "SP");                       
		Endereco e3 = new Endereco(c2, "Jardim das Flores", "Avenida B", 23456789, 123, "Rio de Janeiro", "RJ");       
		Endereco e4 = new Endereco(c2, "Barra da Tijuca", "Avenida E", 56789012, 789, "Rio de Janeiro", "RJ");         
		Endereco e5 = new Endereco(c3, "Vila Nova", "Rua C", 34567890, 987, "Belo Horizonte", "MG");                   
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
	}

}
