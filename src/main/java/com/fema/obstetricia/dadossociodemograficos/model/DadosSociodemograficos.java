package com.fema.obstetricia.dadossociodemograficos.model;

import java.util.Date;

public class DadosSociodemograficos {
	private String dataNascimento;
	private Integer escolaridade;
	private Integer estadoCivil;
	private Integer etnia;
	private Integer profissao;
	private Integer planoDeSaude;
	
	public DadosSociodemograficos() {
		
	}

	public DadosSociodemograficos(String dataNascimento, Integer escolaridade, Integer estadoCivil, Integer etnia,
			Integer profissao, Integer planoDeSaude) {
		super();
		this.dataNascimento = dataNascimento;
		this.escolaridade = escolaridade;
		this.estadoCivil = estadoCivil;
		this.etnia = etnia;
		this.profissao = profissao;
		this.planoDeSaude = planoDeSaude;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getEtnia() {
		return etnia;
	}

	public void setEtnia(Integer etnia) {
		this.etnia = etnia;
	}

	public Integer getProfissao() {
		return profissao;
	}

	public void setProfissao(Integer profissao) {
		this.profissao = profissao;
	}

	public Integer getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(Integer planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}
}
