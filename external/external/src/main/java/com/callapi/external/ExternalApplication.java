package com.callapi.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ExternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalApplication.class, args);
	}

}


