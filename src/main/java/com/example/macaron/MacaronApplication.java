package com.example.macaron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MacaronApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacaronApplication.class, args);
// System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

	
}
