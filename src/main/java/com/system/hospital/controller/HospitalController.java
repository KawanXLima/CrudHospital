package com.system.hospital.controller;

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
    HospitalService hospitalService;

    @Autowired
    private HospitalRepository hospitalRepository;

    private final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @PostMapping("/Cadastrar")
    public ResponseEntity<Hospital> cadastrarHospital(@RequestBody Hospital hospital) {
    try{
        Hospital savedHospital =  hospitalRepository.save(hospital);
        return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
    } catch (Exception e) {
        logger.error("Erro ao cadastrar enfermeiro: " + e.getMessage(), e);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> buscarPorId(@PathVariable Integer id) {
        try {
            Hospital hospital = hospitalService.encontrarPorId(id);
            return ResponseEntity.ok(hospital);
        } catch (Exception e) {
            logger.error("Hospital nao encontrado: " + e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHospital(@PathVariable Integer id) {
        try {
            if (hospitalRepository.existsById(id)) {
                hospitalRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao deletar hospital: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> atualizarHospital(@PathVariable Integer id, @RequestBody Hospital hospital) {
        try {
            if (hospitalRepository.existsById(id)) {
                hospital.setId(id); // Garante que o ID é mantido
                Hospital updatedHospital = hospitalRepository.save(hospital);
                return ResponseEntity.ok(updatedHospital);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao atualizar Hospital: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
