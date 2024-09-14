package com.system.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.service.EnfermeiroService;
import com.system.hospital.model.repository.EnfermeiroRepository;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    @Autowired
    EnfermeiroService service;

    @Autowired
    private EnfermeiroRepository repository;

    private final Logger logger = LoggerFactory.getLogger(EnfermeiroController.class);

    @PostMapping
    public ResponseEntity<Enfermeiro> cadastroEnfermeiro(@RequestBody Enfermeiro enfermeiro) {
        try {
            Enfermeiro savedEnfermeiro = repository.save(enfermeiro);
            return new ResponseEntity<>(savedEnfermeiro, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Erro ao cadastrar enfermeiro: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermeiro> buscarPorId(@PathVariable Integer id) {
        Enfermeiro enfermeiro = service.encontrarPorID(id);
        return ResponseEntity.ok(enfermeiro);
    }
}
