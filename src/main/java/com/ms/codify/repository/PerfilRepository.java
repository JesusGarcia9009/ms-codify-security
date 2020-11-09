package com.ms.codify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.codify.entities.PerfilModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface PerfilRepository extends JpaRepository<PerfilModel, Long> {

	@Query(value = "SELECT p FROM PerfilModel p "
			+ "INNER JOIN p.usuarioPerfilList up " + 
			"WHERE up.usuarioModel.usuario = :usuario ")
	List<PerfilModel> findbyUsername(@Param("usuario") String usuario);
	
	
	@Query(value = "SELECT p FROM PerfilModel p WHERE p.nombre = :nombre ")
	PerfilModel findByNameProfile(@Param("nombre") String nombre);

}
