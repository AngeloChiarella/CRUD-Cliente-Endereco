package br.com.crud.cliente.entities.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.crud.cliente.entities.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EnderecoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;

	@JsonIgnore
	private Cliente cliente;
	
	private Long clienteId;
	
	private String bairro;
	private String logradouro;
	private Integer cep;
	private Integer numero;
	private String cidade;

	@Length(max = 2, min = 2)
	private String uf;

}
