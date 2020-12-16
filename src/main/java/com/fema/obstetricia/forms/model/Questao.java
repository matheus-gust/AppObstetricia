package com.fema.obstetricia.forms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String pergunta;
	
	@ManyToOne
	@JoinColumn(name = "formulario_id")
	@JsonIgnore
	Formulario formulario;
	
	@OneToMany(mappedBy="questao")
	private List<Alternativa> alternativas = new ArrayList<>();
	
	public Questao() {
		
	}

	public Questao(int id, String pergunta, int tipoQuestionario) {
		super();
		this.id = id;
		this.pergunta = pergunta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<Alternativa> getRespostas() {
		return alternativas;
	}

	public void setRespostas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
