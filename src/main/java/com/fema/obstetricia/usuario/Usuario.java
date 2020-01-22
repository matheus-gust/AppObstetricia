package com.fema.obstetricia.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
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
import com.fema.obstetricia.forms.Resposta;
import com.fema.obstetricia.gestacao.Gestacao;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	
	@JsonIgnore
	private String senha;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	private String planoDeSaude;
	private String profissao;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Gestacao> gestacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Resposta> respostas = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable
	private Set<Integer> perfis = new HashSet<>();
	
	private int escolaridade;
	private int estadoCivil;
	private int etinia;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String email, String senha, Date dataNascimento, String planoDeSaude,
			String profissao, EstadoCivil estadoCivil, Etinia etinia, Escolaridade escolaridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.planoDeSaude = planoDeSaude;
		this.profissao = profissao;
		this.estadoCivil = (estadoCivil==null) ? null : estadoCivil.getCod();
		this.etinia = (etinia==null) ? null : etinia.getCod();
		this.escolaridade = (escolaridade==null) ? null : escolaridade.getCod();
		addPerfil(Perfil.CLIENTE);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(estadoCivil);
	}
	
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil.getCod();
	}
	
	public Escolaridade getEscolaridade() {
		return Escolaridade.toEnum(escolaridade);
	}
	
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade.getCod();
	}
	
	public Etinia getEtinia() {
		return Etinia.toEnum(etinia);
	}
	
	public void setEtinia(Etinia etinia) {
		this.etinia = etinia.getCod();
	}
	
	public List<Gestacao> getGestacoes() {
		return gestacoes;
	}

	public void setGestacoes(List<Gestacao> gestacoes) {
		this.gestacoes = gestacoes;
	}
	
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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
