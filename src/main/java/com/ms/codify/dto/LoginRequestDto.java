package com.ms.codify.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginRequestDto - Request - Spring Boot
 *
 * @author Jesus Garcia
 * @version jdk-11
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String username;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String password;
}
