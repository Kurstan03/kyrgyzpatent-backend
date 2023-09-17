package com.example.kyrgyzpatentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KyrgyzpatentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyrgyzpatentBackendApplication.class, args);
	}

	@GetMapping("/")
	public String greeting() {
		return "<h1> Welcome to Kyrgyzpatent! <h1>";
	}

}
