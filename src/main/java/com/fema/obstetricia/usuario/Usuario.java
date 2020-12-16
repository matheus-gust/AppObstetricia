package com.fema.obstetricia.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fema.obstetricia.enums.Escolaridade;
import com.fema.obstetricia.enums.EstadoCivil;
import com.fema.obstetricia.enums.Etinia;
import com.fema.obstetricia.enums.Perfil;
import com.fema.obstetricia.forms.model.Resposta;
import com.fema.obstetricia.gestacao.Gestacao;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private Integer planoDeSaude;
	private Integer profissao;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Gestacao> gestacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable
	private Set<Integer> perfis = new HashSet<>();
	
	private boolean cadastroFinalizado;
	
	private Integer escolaridade;
	private Integer estadoCivil;
	private Integer etnia;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String email, String senha, LocalDate dataNascimento, Integer planoDeSaude,
			Integer profissao, EstadoCivil estadoCivil, Etinia etnia, Escolaridade escolaridade) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.planoDeSaude = planoDeSaude;
		this.profissao = profissao;
		this.estadoCivil = (estadoCivil==null) ? null : estadoCivil.getCod();
		this.etnia = (etnia==null) ? null : etnia.getCod();
		this.escolaridade = (escolaridade==null) ? null : escolaridade.getCod();
		addPerfil(Perfil.CLIENTE);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(estadoCivil);
	}
	
	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Escolaridade getEscolaridade() {
		return Escolaridade.toEnum(escolaridade);
	}
	
	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	public Etinia getEtnia() {
		return Etinia.toEnum(etnia);
	}
	
	public void setEtnia(Integer etnia) {
		this.etnia = etnia;
	}
	
	public List<Gestacao> getGestacoes() {
		return gestacoes;
	}

	public void setGestacoes(List<Gestacao> gestacoes) {
		this.gestacoes = gestacoes;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public boolean isCadastroFinalizado() {
		return cadastroFinalizado;
	}

	public void setCadastroFinalizado(boolean cadastroFinalizado) {
		this.cadastroFinalizado = cadastroFinalizado;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
