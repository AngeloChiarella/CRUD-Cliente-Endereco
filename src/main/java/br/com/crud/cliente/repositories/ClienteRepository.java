package br.com.crud.cliente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.crud.cliente.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
	List<Cliente> findByNomeDto(String nome);

}
