package com.bancodebogota.ptdo.parametria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bancodebogota.ptdo.parametria.configuration.SwaggerConfiguration;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {SpringBootApplication} que inicia la app implemeta de
 * {WebMvcConfigurer} para la configurar la vista de swagger-ui.html
 * 
 * @author Stiven Diaz
 * 
 */
@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class WsRestParametriaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WsRestParametriaApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

	}
}
