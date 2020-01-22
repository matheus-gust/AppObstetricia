package com.fema.obstetricia.gestacao;

import java.util.Date;

import javax.persistence.Entity;

import com.fema.obstetricia.enums.Aborto;
import com.fema.obstetricia.enums.TipoDeParto;
import com.fema.obstetricia.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("gestacaoFinalizada")
public class GestacaoFinalizada extends Gestacao{
	private static final long serialVersionUID = 1L;

	private int numeroDeConsultas;
	private Date dataDoTermino;
	private TipoDeParto tipoDeParto;
	private Aborto aborto;
	
	public GestacaoFinalizada() {
		
	}

	public GestacaoFinalizada(Long id, int semanas, Usuario usuario, int numeroDeConsultas, Date dataDoTermino,
			TipoDeParto tipoDeParto, Aborto aborto) {
		super(id, semanas, usuario);
		this.numeroDeConsultas = numeroDeConsultas;
		this.dataDoTermino = dataDoTermino;
		this.tipoDeParto = tipoDeParto;
		this.aborto = aborto;
	}

	public int getNumeroDeConsultas() {
		return numeroDeConsultas;
	}

	public void setNumeroDeConsultas(int numeroDeConsultas) {
		this.numeroDeConsultas = numeroDeConsultas;
	}

	public Date getDataDoTermino() {
		return dataDoTermino;
	}

	public void setDataDoTermino(Date dataDoTermino) {
		this.dataDoTermino = dataDoTermino;
	}

	public TipoDeParto getTipoDeParto() {
		return tipoDeParto;
	}

	public void setTipoDeParto(TipoDeParto tipoDeParto) {
		this.tipoDeParto = tipoDeParto;
	}

	public Aborto getAborto() {
		return aborto;
	}

	public void setAborto(Aborto aborto) {
		this.aborto = aborto;
	}
}
