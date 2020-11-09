package com.ms.codify;

import org.springframework.beans.factory.annotation.Value;
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
public class MsSessionApplication {
	
	@Value("${api.config.base.uri}")
	private String urlServicio = "";

	public static void main(String[] args) {
		SpringApplication.run(MsSessionApplication.class, args);
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("[webServerFactoryCustomizer] :: "+ urlServicio);
		return factory -> factory.setContextPath(this.urlServicio);
	}

}
