package com.innoventes.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
public class InnoventesSpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnoventesSpringbootTestApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
