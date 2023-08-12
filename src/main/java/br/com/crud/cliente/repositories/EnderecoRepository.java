package br.com.crud.cliente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.crud.cliente.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("SELECT e FROM Endereco e WHERE e.cliente.nome LIKE %:nome%")
	List<Endereco> findByNomeCliente(String nome);
	
	@Query("SELECT e FROM Endereco e WHERE e.logradouro LIKE %:logradouro%")
	List<Endereco> findByNomeRua(String logradouro);

	@Query("SELECT e FROM Endereco e WHERE e.cliente.id = :id")
	List<Endereco> findByClienteId(Long id);

	List<Endereco> findByUf(String uf);

}
