package com.ms.codify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.codify.dto.CodifyUserDto;
import com.ms.codify.dto.ProfileDto;
import com.ms.codify.entities.PerfilModel;
import com.ms.codify.entities.UsuarioModel;
import com.ms.codify.repository.PerfilRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService servicio de usuario para Sprint Security
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersService usersService;

	@Autowired
	private PerfilRepository profile;

	@Override
	public CodifyUserDto loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		UsuarioModel user = null;

		user = usersService.buscarUserByNameOrRut(usernameOrEmail);

		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		log.info("[loadUserByUsername]::fin de metodo");
		return createUserCodify(user);
	}

	/**
	 * Genera el Usuario a guardar en el token con toda su informacion y permisos
	 * asociados
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private CodifyUserDto createUserCodify(UsuarioModel userDto) {
		log.info("[createUserCodify]::inicio de metodo");
		CodifyUserDto codifyUser = new CodifyUserDto();

		codifyUser.setIdUsuario(userDto.getIdUsuario());
		codifyUser.setFullName(userDto.getNombre() + " " + userDto.getApellidoPaterno());
		codifyUser.setUsername(userDto.getUsuario());
		codifyUser.setRut(userDto.getRut());
		codifyUser.setPassword(userDto.getPass());

		List<ProfileDto> rolList = getRolList(userDto.getUsuario());
		codifyUser.setListProfiles(rolList);

		if (!rolList.isEmpty()) {
			List<GrantedAuthority> authorities = rolList.stream()
					.map(permiso -> new SimpleGrantedAuthority(permiso.getDscProfile())).collect(Collectors.toList());
			codifyUser.setAuthorities(authorities);
		}

		log.info("[createUserCodify]::fin de metodo");
		return codifyUser;
	}

	private List<ProfileDto> getRolList(String userName) {
		log.info("[createUserCodify:RolList]::inicio de metodo");
		List<ProfileDto> rolList = new ArrayList<>();
		// Roles
		List<PerfilModel> list = profile.findbyUsername(userName);
		for (PerfilModel rol : list) {
			ProfileDto r = new ProfileDto();
			r.setIdProfile(rol.getIdPerfil());
			r.setDscProfile(rol.getNombre());
			rolList.add(r);
		}
		log.info("[createUserCodify:RolList]::fin de metodo");
		return rolList;
	}

}