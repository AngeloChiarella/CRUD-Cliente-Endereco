package br.com.crud.cliente.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Entity
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String logradouro;

	@Column(length = 8, nullable = false)
	private Integer cep;

	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = false)
	private String cidade;

	@Column(length = 2, nullable = false)
	private String uf;

	public Endereco(Cliente cliente, String bairro, String logradouro, Integer cep, Integer numero, String cidade,
			String uf) {
		this.cliente = cliente;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	
}
