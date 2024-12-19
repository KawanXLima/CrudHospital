package com.system.hospital.service;

import com.system.hospital.model.DTOs.EnfermeiroAddDTO;
import com.system.hospital.model.DTOs.HospitalAddDTO;
import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.model.entity.Hospital;
import com.system.hospital.model.repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class HospitalService {
@Autowired
    private HospitalRepository repository;

public Hospital encontrarPorId(Integer id) {
    return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital não encontrado"));
}
    public Hospital createHospital (HospitalAddDTO hospitalAddDTO){
        Hospital hospital = new Hospital();
        hospital.setNome(hospitalAddDTO.getNome());
        hospital.setEndereco(hospitalAddDTO.getEndereco());
        return repository.save(hospital);
    }
    public Hospital readHospital(Integer id){
        Optional<Hospital> optionalHospital = repository.findById(id);
        if(optionalHospital.isPresent()){
            return optionalHospital.get();
        } else{
            throw new RuntimeException("Hospital não encontrado");
        }
    }
    public Hospital updateHospital(Integer id, HospitalAddDTO hospitalAddDTO) {
        Hospital hospital = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital não encontrado"));
        hospital.setNome(hospitalAddDTO.getNome());
        hospital.setEndereco(hospitalAddDTO.getEndereco());
        return repository.save(hospital);
    }
    public void deleteHospital(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else{
            throw new RuntimeException("Hospital não encontrado");
        }
    }
}
