package com.fema.obstetricia.usuario.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
public class UsuarioDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	//@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;

	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private Integer planoDeSaude;
	
	private Integer profissao;
	
	private Integer escolaridade;
	
	private Integer estadoCivil;
	
	private Integer etinia;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(Integer planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public Integer getProfissao() {
		return profissao;
	}

	public void setProfissao(Integer profissao) {
		this.profissao = profissao;
	}

	public int getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(int escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getEtinia() {
		return etinia;
	}

	public void setEtinia(int etinia) {
		this.etinia = etinia;
	}
}
