package com.callapi.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Service
@RestController
public class ExternalController {

    private final RestTemplate restTemplate;

    public ExternalController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping("hello")
    public String hello() {
        return "Yooooo";
    }

    @GetMapping(value = "/cats")
    public String getCats() {
        String url = "https://api.thecatapi.com/v1/images/search";
        return this.restTemplate.getForObject(url, String.class);
    }

    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry
                    .addResourceHandler("/images/**")
                    .addResourceLocations("file:C:\\Users\\patri\\Downloads\\project\\project\\src\\main\\resources\\images\\")
                    .setCachePeriod(0);
        }
    }
}