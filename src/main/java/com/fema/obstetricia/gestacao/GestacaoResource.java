package com.fema.obstetricia.gestacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="gestacao")
public class GestacaoResource {

	//Teste
	@GetMapping
	ResponseEntity<List<Gestacao>> listarGestacao() {
		Gestacao gestacao = new Gestacao();
		List<Gestacao> gestacoes = new ArrayList<>();
		gestacoes.add(gestacao);
		return ResponseEntity.ok().body(gestacoes);
	}
}
