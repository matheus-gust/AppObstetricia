package com.fema.obstetricia.forms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fema.obstetricia.forms.model.FormApi;
import com.fema.obstetricia.forms.service.FormularioService;

@RestController
@RequestMapping("/formulario")
public class FormularioResource {
	
	@Autowired
	FormularioService formularioService;
	
	@GetMapping
	public ResponseEntity<FormApi> listarFormularios() {
		return ResponseEntity.ok().body(this.formularioService.listarFormuarios());
	}
	
}
