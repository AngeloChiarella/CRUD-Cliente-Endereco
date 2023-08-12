package br.com.crud.cliente.entities.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank @Email
	private String email;
	
	@NotBlank 
	@CPF(message = "CPF inválido")
	@Size(max = 14, min = 14, message = "A formatacao deve ser ###.###.###-##")
	private String cpf;
	
	public ClienteDto(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	
}
