package com.animalRandomizer.Image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = BatchAutoConfiguration.class)
public class ImageApplication {
    private static final Logger log = LoggerFactory.getLogger(ImageApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ImageApplication.class, args);

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            InData inData = restTemplate.getForObject(
                    "https://random-d.uk/api/random", InData.class);
            log.info(inData.toString());

            WebbController.inData = inData;
        };
    }

}