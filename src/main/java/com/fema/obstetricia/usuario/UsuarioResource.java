package com.fema.obstetricia.usuario;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fema.obstetricia.dadossociodemograficos.model.DadosSociodemograficos;
import com.fema.obstetricia.usuario.dto.CadastroFinalizadoDTO;
import com.fema.obstetricia.usuario.dto.UsuarioNewDTO;

@RestController
@RequestMapping(value="usuario")
public class UsuarioResource {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@PostMapping(value = "/cadastro")
	public ResponseEntity<Void> novoUsuario(@Valid @RequestBody UsuarioNewDTO usuario){
		Usuario novoUsuario = new Usuario(null, usuario.getEmail(), pe.encode(usuario.getSenha()), null, null, null, null, null, null);
		novoUsuario = usuarioService.cadastrarUsuario(novoUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoUsuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping(value = "/cadastro-sociodemograficos")
	public ResponseEntity<Void> cadastrarDadosSociodemograficos(@Valid @RequestBody DadosSociodemograficos dados) {
		System.out.println(dados.getDataNascimento());
		usuarioService.cadastrarDadosSociodemograficos(dados);
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping(value = "/cadastro-finalizado")
	public ResponseEntity<CadastroFinalizadoDTO> verificarCadastroFinalizado() {
		return ResponseEntity.ok().body(this.usuarioService.verificarCadastroFinalizado());
	}

}
