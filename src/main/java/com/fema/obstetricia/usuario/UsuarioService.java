package com.fema.obstetricia.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fema.obstetricia.enums.Escolaridade;
import com.fema.obstetricia.enums.EstadoCivil;
import com.fema.obstetricia.enums.Etinia;
import com.fema.obstetricia.usuario.dto.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		usuario.setId(null);
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Usuario fromDTO(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario(null, usuarioDto.getNome(), usuarioDto.getEmail(), pe.encode(usuarioDto.getSenha()), 
				usuarioDto.getDataNascimento(), usuarioDto.getPlanoDeSaude(), usuarioDto.getProfissao(), 
				EstadoCivil.toEnum(usuarioDto.getEstadoCivil()), Etinia.toEnum(usuarioDto.getEtinia()), 
				Escolaridade.toEnum(usuarioDto.getEscolaridade()));
		return usuario;
	}
}
