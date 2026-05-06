package com.riwi.LabSpringBoot.controllers;

import com.riwi.LabSpringBoot.services.CoderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coders/stats")
@Tag(name = "Coders", description = "Operaciones relacionadas con metricas de coders")
public class CoderStatsController {

    private final CoderService coderService;

    public CoderStatsController(CoderService coderService) {
        this.coderService = coderService;
    }

    @Operation(summary = "Contar coders", description = "Retorna la cantidad total de coders guardados en memoria.")
    @ApiResponse(responseCode = "200", description = "Conteo obtenido correctamente")
    @GetMapping("/count")
    public int count() {
        return coderService.getAll().size();
    }
}
