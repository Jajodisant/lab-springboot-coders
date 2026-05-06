package com.riwi.LabSpringBoot.services;

import com.riwi.LabSpringBoot.dtos.CoderRequest;
import com.riwi.LabSpringBoot.models.Coder;
import com.riwi.LabSpringBoot.repositories.CoderRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CoderService {

    private final CoderRepository repository;

    public CoderService(CoderRepository repository) {
        System.out.println("Creando una nueva instancia de CoderService");
        this.repository = repository;
    }

    public List<Coder> getAll() {
        return repository.findAll();
    }

    public Coder getById(Long id) {
        return repository.findAll().stream()
                .filter(coder -> coder.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Coder> searchByClan(String clan) {
        return repository.findAll().stream()
                .filter(coder -> coder.getClan().equalsIgnoreCase(clan))
                .toList();
    }

    public Coder create(CoderRequest coderRequest) {
        if (coderRequest.getName() == null || coderRequest.getName().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        Coder coder = new Coder(
                coderRequest.getId(),
                coderRequest.getName(),
                coderRequest.getClan()
        );

        repository.save(coder);
        return coder;
    }

    public Coder update(Long id, CoderRequest coderRequest) {
        Coder coderToUpdate = getById(id);

        if (coderToUpdate == null) {
            return null;
        }

        coderToUpdate.setName(coderRequest.getName());
        coderToUpdate.setClan(coderRequest.getClan());

        return coderToUpdate;
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }
}
