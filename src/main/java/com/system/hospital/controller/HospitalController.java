package com.system.hospital.controller;

import com.system.hospital.model.DTOs.EnfermeiroAddDTO;
import com.system.hospital.model.DTOs.HospitalAddDTO;
import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.model.entity.Hospital;
import com.system.hospital.model.repository.HospitalRepository;
import com.system.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.system.hospital.model.entity.Hospital;
import com.system.hospital.service.HospitalService;
import com.system.hospital.model.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    HospitalService service;

    private final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @PostMapping("/Cadastrar")
    public ResponseEntity<Hospital> cadastroHospital(@RequestBody HospitalAddDTO hospital) {
        try {
            Hospital savedHospital = service.createHospital(hospital);
            return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Erro ao cadastrar enfermeiro: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> readHospital(@PathVariable Integer id){
        try{
            Hospital hospital = service.readHospital(id);
            return ResponseEntity.ok(hospital);
        } catch (RuntimeException e){
            System.err.println("Erro: "+ e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Integer id, @RequestBody HospitalAddDTO hospitalAddDTO) {
        try {
            Hospital updatedHospital = service.updateHospital(id, hospitalAddDTO);
            return ResponseEntity.ok(updatedHospital);
        } catch (RuntimeException e) {
            System.err.println("Erro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Integer id){
        try{
            service.deleteHospital(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            System.err.println("Erro: "+e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
