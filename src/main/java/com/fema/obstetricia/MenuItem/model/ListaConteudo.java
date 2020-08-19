package com.fema.obstetricia.MenuItem.model;

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
import com.fema.obstetricia.conteudo.Paragrafo;

@Entity
public class ListaConteudo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="menu_id")
	private ModeloMenuPrincipal menuPrincipal;
	
	@OneToMany(mappedBy = "listaConteudo")
	private List<Paragrafo> paragrafos = new ArrayList<>();
	
	public ListaConteudo() {
		
	}

	public ListaConteudo(Long id, String titulo, ModeloMenuPrincipal menuPrincipal) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.menuPrincipal = menuPrincipal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

	public ModeloMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}



	public void setMenuPrincipal(ModeloMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}



	public List<Paragrafo> getParagrafos() {
		return paragrafos;
	}

	public void setParagrafos(List<Paragrafo> paragrafos) {
		this.paragrafos = paragrafos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ListaConteudo other = (ListaConteudo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
