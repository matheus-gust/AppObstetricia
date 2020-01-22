package com.fema.obstetricia.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String pergunta;
	private int tipoQuestionario;
	
	@OneToMany(mappedBy="questao")
	private List<Resposta> respostas = new ArrayList<>();
	
	public Questao() {
		
	}

	public Questao(int id, String pergunta, int tipoQuestionario) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.tipoQuestionario = tipoQuestionario;
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

	public int getTipoQuestionario() {
		return tipoQuestionario;
	}

	public void setTipoQuestionario(int tipoQuestionario) {
		this.tipoQuestionario = tipoQuestionario;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
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
