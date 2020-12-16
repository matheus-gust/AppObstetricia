package com.fema.obstetricia.forms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formulario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "formulario")
	private List<Questao> questoes = new ArrayList<Questao>();
	private String descricao;
	
	public Formulario() {
		
	}
	
	public Formulario(Integer id, List<Questao> questoes, String descricao) {
		super();
		this.id = id;
		this.questoes = questoes;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	public String getDscricao() {
		return descricao;
	}
	public void setDscricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
