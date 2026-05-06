package com.riwi.LabSpringBoot.controllers;

import com.riwi.LabSpringBoot.services.GreetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Saludos", description = "Operaciones basicas de bienvenida")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Operation(summary = "Generar saludo personalizado", description = "Retorna un mensaje de bienvenida para el nombre recibido.")
    @ApiResponse(responseCode = "200", description = "Saludo generado correctamente")
    @GetMapping("/greet")
    public String greet(@Parameter(description = "Nombre de la persona que recibira el saludo", example = "Pepito")
                        @RequestParam(defaultValue = "Coder") String name) {
        return greetingService.getPersonalizedGreeting(name);
    }
}
