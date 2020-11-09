package com.ms.codify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.codify.entities.UsuarioModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	UsuarioModel findByRutOrUsuario(String rut, String username);
	
	Long countByRutOrUsuario(String rut, String username);
	
}
