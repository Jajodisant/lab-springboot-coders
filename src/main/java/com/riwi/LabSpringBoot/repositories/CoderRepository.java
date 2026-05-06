package com.riwi.LabSpringBoot.repositories;

import com.riwi.LabSpringBoot.models.Coder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoderRepository {

    private final List<Coder> coders = new ArrayList<>();

    public List<Coder> findAll() {
        return coders;
    }

    public void save(Coder coder) {
        coders.add(coder);
    }

    public boolean deleteById(Long id) {
        return coders.removeIf(coder -> coder.getId().equals(id));
    }
}
