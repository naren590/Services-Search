package com.example.services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("My API")
                    .version("3.0.0")
                    .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                    .termsOfService("http://swagger.io/terms/")
                    .contact(new Contact().name("John Doe").url("http://example.com").email("john.doe@example.com"))
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
