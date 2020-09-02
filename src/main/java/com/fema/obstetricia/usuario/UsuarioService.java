package com.fema.obstetricia.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fema.obstetricia.dadossociodemograficos.model.DadosSociodemograficos;
import com.fema.obstetricia.enums.Escolaridade;
import com.fema.obstetricia.enums.EstadoCivil;
import com.fema.obstetricia.enums.Etinia;
import com.fema.obstetricia.enums.Perfil;
import com.fema.obstetricia.exceptions.AuthorizationException;
import com.fema.obstetricia.security.UsuarioSS;
import com.fema.obstetricia.usuario.dto.CadastroFinalizadoDTO;
import com.fema.obstetricia.usuario.dto.UsuarioDTO;

@Service
public class UsuarioService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> getUsuarios() {

		UsuarioSS user = UsuarioLogadoService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("Não tem permissão");
		}

		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	public Usuario cadastrarUsuario(Usuario usuario) {
		usuario.setId(null);
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario fromDTO(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario(null, usuarioDto.getEmail(),
				pe.encode(usuarioDto.getSenha()), usuarioDto.getDataNascimento(), usuarioDto.getPlanoDeSaude(),
				usuarioDto.getProfissao(), EstadoCivil.toEnum(usuarioDto.getEstadoCivil()),
				Etinia.toEnum(usuarioDto.getEtinia()), Escolaridade.toEnum(usuarioDto.getEscolaridade()));
		return usuario;
	}

	public void cadastrarDadosSociodemograficos(DadosSociodemograficos dados) {
		UsuarioSS user = UsuarioLogadoService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Login não efetuado");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Usuario usuario = usuarioRepository.findById(user.getId()).get();
		usuario.setDataNascimento(LocalDate.parse(dados.getDataNascimento(), formatter));
		usuario.setEscolaridade(dados.getEscolaridade());
		usuario.setEtnia(dados.getEtnia());
		usuario.setEstadoCivil(dados.getEstadoCivil());
		usuario.setProfissao(dados.getProfissao());
		usuario.setPlanoDeSaude(dados.getPlanoDeSaude());
		usuario.setCadastroFinalizado(true);
		usuarioRepository.save(usuario);
	}
	
	public CadastroFinalizadoDTO verificarCadastroFinalizado() {
		UsuarioSS user = UsuarioLogadoService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Login não efetuado");
		}
		Usuario usuario = this.usuarioRepository.findById(user.getId()).get();
		return new CadastroFinalizadoDTO(usuario.isCadastroFinalizado());
	}
}
