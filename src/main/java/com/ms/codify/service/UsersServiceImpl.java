package com.ms.codify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.entities.UsuarioModel;
import com.ms.codify.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * UsersServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsuarioRepository usersRepository;
	
	
	@Override
	public UsuarioModel buscarUsers(Long id) {
		log.info("[buscarUsers]::inicio de metodo");
		Optional<UsuarioModel> optional = usersRepository.findById(id);
		UsuarioModel result = null;
		if(optional.isPresent())
			result = optional.get();
		else
			result = null;
		log.info("[buscarUsers]::fin de metodo");
		return result;
	}
	
	
	@Override
	public UsuarioModel buscarUserByNameOrRut(String userNameOrRut) {
		log.info("[buscarUserByNameOrRut]::inicio de metodo");
		UsuarioModel resultado = null;
		resultado = usersRepository.findByRutOrUsuario(userNameOrRut, userNameOrRut);
		
		log.info("[buscarUserByNameOrRut]::fin de metodo");
		return resultado;
	}
	
	@Override
	public Long countUserByNameOrRut(String userNameOrRut) {
		log.info("[countUserByNameOrRut]::inicio de metodo");
		Long resultado = null;
		resultado = usersRepository.countByRutOrUsuario(userNameOrRut, userNameOrRut);
		
		log.info("[countUserByNameOrRut]::fin de metodo");
		return resultado;
	}

	
	
	
}
