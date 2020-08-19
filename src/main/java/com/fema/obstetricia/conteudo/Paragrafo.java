package com.fema.obstetricia.conteudo;

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
import com.fema.obstetricia.MenuItem.model.ListaConteudo;

@Entity
public class Paragrafo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="paragrafo")
	private List<Conteudo> conteudo = new ArrayList<>();
	
	@OneToMany(mappedBy="paragrafo")
	private List<ImagemConteudo> imagem = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="lista_conteudo_id")
	private ListaConteudo listaConteudo;
	
	public Paragrafo() {
	}
	
	

	public Paragrafo(Long id, List<Conteudo> conteudo, List<ImagemConteudo> imagem, ListaConteudo listaConteudo) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.imagem = imagem;
		this.listaConteudo = listaConteudo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Conteudo> getConteudo() {
		return conteudo;
	}

	public void setConteudo(List<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}

	public List<ImagemConteudo> getImagem() {
		return imagem;
	}

	public void setImagem(List<ImagemConteudo> imagem) {
		this.imagem = imagem;
	}

	public ListaConteudo getListaConteudo() {
		return listaConteudo;
	}

	public void setListaConteudo(ListaConteudo listaConteudo) {
		this.listaConteudo = listaConteudo;
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
		Paragrafo other = (Paragrafo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
