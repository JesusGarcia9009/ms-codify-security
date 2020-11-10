package com.ms.codify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.dto.CodifyUserDto;
import com.ms.codify.dto.LoginRequestDto;
import com.ms.codify.dto.LoginResponseDto;
import com.ms.codify.exception.UserNotAuthException;
import com.ms.codify.utils.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.codify.base.uri}/login")
@Slf4j
public class LoginUserControllerImpl implements LoginUserController {

	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/auth")
	public ResponseEntity<LoginResponseDto> autenticacionUsuario(@Valid @RequestBody LoginRequestDto dto) throws UserNotAuthException{
		log.info("[autenticacionUsuario] :: Inicio del Metodo" );
		ResponseEntity<LoginResponseDto> response = null;

		
		Authentication sigin = null;
		sigin = jwtTokenUtil.createToken(dto.getUsername(), dto.getPassword());
		
		LoginResponseDto autPass = new LoginResponseDto();
		CodifyUserDto userPrincipal = (CodifyUserDto) sigin.getPrincipal();
		autPass.setToken(jwtTokenUtil.generateToken(sigin));

		autPass.setUsername(userPrincipal.getUsername());
		autPass.setFullName(userPrincipal.getFullName());
		autPass.setId(userPrincipal.getIdUsuario());

		response = new ResponseEntity<>(autPass, HttpStatus.OK);
		log.info("[autenticacionUsuario] :: Fin del Metodo" );
		return response;
	}
	
}
