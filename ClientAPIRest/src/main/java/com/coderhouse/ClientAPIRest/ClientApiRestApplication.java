package com.coderhouse.ClientAPIRest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApiRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listenign. Access H2 on: http://localhost:8080/h2-console");
	}
}
