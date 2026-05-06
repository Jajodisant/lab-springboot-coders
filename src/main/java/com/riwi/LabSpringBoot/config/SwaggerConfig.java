package com.riwi.LabSpringBoot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Laboratorios Spring Boot Riwi",
                version = "1.0",
                description = "Documentación de endpoints para practicar controladores, servicios, repositorios y comunicación REST.",
                contact = @Contact(name = "Soporte Riwi", email = "soporte@riwi.io")
        ),
        tags = {
                @Tag(name = "Coders", description = "Operaciones relacionadas con la gestión de coders"),
                @Tag(name = "Tareas", description = "Operaciones del reto TaskCount"),
                @Tag(name = "Saludos", description = "Operaciones básicas de bienvenida")
        }
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi codersModule() {
        return GroupedOpenApi.builder()
                .group("Coders")
                .pathsToMatch("/api/coders/**")
                .build();
    }

    @Bean
    public GroupedOpenApi tasksModule() {
        return GroupedOpenApi.builder()
                .group("Tareas")
                .pathsToMatch("/tasks/**")
                .build();
    }

    @Bean
    public GroupedOpenApi greetingsModule() {
        return GroupedOpenApi.builder()
                .group("Saludos")
                .pathsToMatch("/greet")
                .build();
    }
}
