package com.animalRandomizer.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args); }
		// Startar och kör applicationen

	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);
	// Loggar applicationen.



	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){return builder.build();}
	// Bygger ?

}
