package com.system.hospital.service;

import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.model.repository.EnfermeiroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EnfermeiroService {

    @Autowired
    private EnfermeiroRepository repository;

    public Enfermeiro encontrarPorID (Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enfermeiro não encontrado"));
    }
}