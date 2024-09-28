package com.system.hospital.service;

import com.system.hospital.model.entity.Hospital;
import com.system.hospital.model.repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HospitalService {
@Autowired
    private HospitalRepository hospitalRepository;

public Hospital encontrarPorId(Integer id) {
    return hospitalRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital não encontrado"));
}
}
