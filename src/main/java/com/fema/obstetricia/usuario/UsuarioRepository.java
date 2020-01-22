package com.fema.obstetricia.usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);

}
