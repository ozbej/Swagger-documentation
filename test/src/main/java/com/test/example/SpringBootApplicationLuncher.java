package com.test.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	     info = @Info(
	               title = "Hello World API",
	               version = "v3",
		       description = "This app provides documentation",
		       contact = @Contact(
					name = "Ožbej Golob & Bian Klančnik"
				)
			)
	)
public class SpringBootApplicationLuncher {
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldController.class, args);
	}
}