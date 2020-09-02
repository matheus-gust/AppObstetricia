package com.fema.obstetricia.usuario.dto;

import javax.validation.constraints.NotEmpty;

public class UsuarioNewDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	//@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	UsuarioNewDTO() {
		
	}

	
	public UsuarioNewDTO(@NotEmpty(message = "Preenchimento obrigatório")
			@NotEmpty(message = "Preenchimento obrigatório") String email,
			@NotEmpty(message = "Preenchimento obrigatório") String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
