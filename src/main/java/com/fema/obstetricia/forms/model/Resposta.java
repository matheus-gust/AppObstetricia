package com.fema.obstetricia.forms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fema.obstetricia.usuario.Usuario;

@Entity
public class Resposta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "alternativa_id")
	private Integer alternativa;
	
	public Resposta() {
		
	}

	public Resposta(Integer id, Usuario usuario, Integer alternativa) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.alternativa = alternativa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Integer alternativa) {
		this.alternativa = alternativa;
	}
	
	

}
