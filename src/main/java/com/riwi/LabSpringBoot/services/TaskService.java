package com.riwi.LabSpringBoot.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final List<String> tasks = List.of(
            "Crear el servicio GreetingService",
            "Exponer el endpoint /greet",
            "Registrar un bean manual",
            "Resolver el reto TaskCount"
    );

    public int getTaskCount() {
        return tasks.size();
    }
}
