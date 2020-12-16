package com.fema.obstetricia.forms.model;

import java.util.List;

public class FormApi {
	private List<Formulario> formularios;

	public FormApi(List<Formulario> formularios) {
		super();
		this.formularios = formularios;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
}
