package com.riwi.LabSpringBoot.controllers;

import com.riwi.LabSpringBoot.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Tareas", description = "Operaciones del reto TaskCount")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Contar tareas", description = "Retorna la cantidad de tareas definidas en el servicio.")
    @ApiResponse(responseCode = "200", description = "Cantidad de tareas obtenida correctamente")
    @GetMapping("/tasks/count")
    public int countTasks() {
        return taskService.getTaskCount();
    }
}
