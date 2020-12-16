package com.fema.obstetricia.forms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fema.obstetricia.forms.model.FormApi;
import com.fema.obstetricia.forms.repository.FormularioRepository;

@Service
public class FormularioService {
	
	@Autowired
	FormularioRepository formularioRepository;
	
	public FormApi listarFormuarios() {
		return new FormApi(this.formularioRepository.findAll());
	}
}
