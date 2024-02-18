package com.codigo.msapazamamani.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MS-Apaza-Mamani API",
                "MS-Apaza-Mamani RESTful API documentation",
                "1.0",
                "Terms of service",
                new Contact("John Doe", "http://www.example.com", "john.doe@example.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}