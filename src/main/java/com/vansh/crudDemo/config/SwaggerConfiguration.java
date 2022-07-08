package com.vansh.crudDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vansh.crudDemo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getInfo());
    }

    private ApiInfo getInfo() {
        return new ApiInfo(
                "My First SpringBoot CRUD Application",
                "Spring Boot Crud Application designed to access different Course Details.",
                "1.0",
                "Terms of service",
                new Contact("Vansh Garg", "https://localhost:8080/courses/", "vansh.garg@geminisolutions.com"),
                "Apache License Version 2.0",
                "Apache License", new ArrayList<>());
    }
}
