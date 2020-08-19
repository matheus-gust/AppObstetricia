package com.fema.obstetricia.MenuItem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModeloMenuPrincipal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	int colunas;
    int linhas;
    String tagHero;
    String titulo;
    String cor;
    
    @OneToMany(mappedBy = "menuPrincipal")
    List<ListaConteudo> listaConteudo = new ArrayList<>();
    
    public ModeloMenuPrincipal() {
    	
    }

	public ModeloMenuPrincipal(Long id, int colunas, int linhas, String tagHero, String titulo, String cor) {
		super();
		this.id = id;
		this.colunas = colunas;
		this.linhas = linhas;
		this.tagHero = tagHero;
		this.titulo = titulo;
		this.cor = cor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public String getTagHero() {
		return tagHero;
	}

	public void setTagHero(String tagHero) {
		this.tagHero = tagHero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<ListaConteudo> getListaConteudo() {
		return listaConteudo;
	}

	public void setListaConteudo(List<ListaConteudo> listaConteudo) {
		this.listaConteudo = listaConteudo;
	}
	
	
}
