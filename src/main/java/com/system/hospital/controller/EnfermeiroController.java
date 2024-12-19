package com.system.hospital.controller;

import com.system.hospital.model.DTOs.EnfermeiroAddDTO;
import com.system.hospital.model.entity.Relatorio;
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

    private final Logger logger = LoggerFactory.getLogger(EnfermeiroController.class);

    //Cadastra de Enfermeiros
    @PostMapping("/Cadastrar")
    public ResponseEntity<Enfermeiro> cadastroEnfermeiro(@RequestBody EnfermeiroAddDTO enfermeiro) {
        try {
            Enfermeiro savedEnfermeiro = service.createEnfermeiro(enfermeiro);
            return new ResponseEntity<>(savedEnfermeiro, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Erro ao cadastrar enfermeiro: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Busca Enfermeiros por ID
    @GetMapping("/{id}")
    public ResponseEntity<Enfermeiro> readEnfermeiro(@PathVariable Integer id){
        try{
            Enfermeiro enfermeiro = service.readEnfermeiro(id);
            return ResponseEntity.ok(enfermeiro);
        } catch (RuntimeException e){
            System.err.println("Erro: "+ e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    //Edita as informações de Enfermeiro por ID
    @PutMapping("/{id}")
    public ResponseEntity<Enfermeiro> updateEnfermeiro(@PathVariable Integer id, @RequestBody EnfermeiroAddDTO enfermeiroDTO) {
        try {
            Enfermeiro updatedEnfermeiro = service.updateEnfermeiro(id, enfermeiroDTO);
            return ResponseEntity.ok(updatedEnfermeiro);
        } catch (RuntimeException e) {
            System.err.println("Erro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //Deleta Enfermeiro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnfermeiro(@PathVariable Integer id){
        try{
            service.deleteEnfermeiro(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            System.err.println("Erro: "+e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
