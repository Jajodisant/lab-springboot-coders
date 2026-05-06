package com.riwi.LabSpringBoot.controllers;

import com.riwi.LabSpringBoot.dtos.CoderRequest;
import com.riwi.LabSpringBoot.models.Coder;
import com.riwi.LabSpringBoot.services.CoderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coders")
@Tag(name = "Coders", description = "Operaciones relacionadas con la gestion de coders")
public class CoderController {

    private final CoderService coderService;

    public CoderController(CoderService coderService) {
        this.coderService = coderService;
    }

    @Operation(summary = "Obtener todos los coders", description = "Retorna todos los coders guardados en memoria.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Coder> getAll() {
        return coderService.getAll();
    }

    @Operation(summary = "Obtener coder por ID", description = "Busca un coder especifico usando su identificador.")
    @ApiResponse(responseCode = "200", description = "Busqueda ejecutada correctamente")
    @GetMapping("/{id}")
    public Coder getById(@Parameter(description = "ID del coder que se desea consultar", example = "1") @PathVariable Long id) {
        return coderService.getById(id);
    }

    @Operation(summary = "Buscar coders por clan", description = "Filtra los coders que pertenecen al clan indicado.")
    @ApiResponse(responseCode = "200", description = "Busqueda por clan ejecutada correctamente")
    @GetMapping("/search")
    public List<Coder> searchByClan(@Parameter(description = "Nombre del clan usado como filtro", example = "Lovelace") @RequestParam String clan) {
        return coderService.searchByClan(clan);
    }

    @Operation(summary = "Crear un coder", description = "Registra un nuevo coder en la lista en memoria.")
    @ApiResponse(responseCode = "200", description = "Coder creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos")
    @PostMapping
    public Coder create(@RequestBody CoderRequest coderRequest) {
        return coderService.create(coderRequest);
    }

    @Operation(summary = "Actualizar un coder", description = "Actualiza el nombre y clan de un coder existente.")
    @ApiResponse(responseCode = "200", description = "Coder actualizado correctamente")
    @PutMapping("/{id}")
    public Coder update(@Parameter(description = "ID del coder que se desea actualizar", example = "1") @PathVariable Long id,
                        @RequestBody CoderRequest coderRequest) {
        return coderService.update(id, coderRequest);
    }

    @Operation(summary = "Eliminar un coder", description = "Elimina un coder de la lista en memoria usando su ID.")
    @ApiResponse(responseCode = "200", description = "Eliminacion ejecutada correctamente")
    @DeleteMapping("/{id}")
    public String delete(@Parameter(description = "ID del coder que se desea eliminar", example = "1") @PathVariable Long id) {
        boolean removed = coderService.delete(id);

        if (removed) {
            return "Coder eliminado correctamente.";
        }

        return "No se encontró un coder con el id " + id + ".";
    }
}
