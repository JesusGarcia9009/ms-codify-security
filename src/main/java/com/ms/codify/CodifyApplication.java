package com.ms.codify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * Inicializacion del Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Slf4j
@SpringBootApplication
public class CodifyApplication {
	
//	private String urlServicio = "/api/pdr/v01/common";

	public static void main(String[] args) {
		SpringApplication.run(CodifyApplication.class, args);
	}
	
//	@Bean
//	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
//		log.info("[webServerFactoryCustomizer] :: "+ urlServicio);
//		return factory -> factory.setContextPath(this.urlServicio);
//	}

}
