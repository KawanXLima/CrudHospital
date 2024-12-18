package com.system.hospital.service;

import com.system.hospital.model.DTOs.EnfermeiroAddDTO;
import com.system.hospital.model.DTOs.RelatorioAddDTO;
import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.model.entity.Hospital;
import com.system.hospital.model.entity.Relatorio;
import com.system.hospital.model.repository.EnfermeiroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EnfermeiroService {

    @Autowired
    private HospitalService service;
    @Autowired
    private EnfermeiroRepository repository;

    public Enfermeiro encontrarPorID (Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enfermeiro não encontrado"));
    }
    public Enfermeiro createEnfermeiro (EnfermeiroAddDTO enfermeiroAddDTO){
        Hospital hospital = service.encontrarPorId(enfermeiroAddDTO.getHospital_id());
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setNome(enfermeiroAddDTO.getNome());
        enfermeiro.setIdade(enfermeiroAddDTO.getIdade());
        enfermeiro.setCpf(enfermeiroAddDTO.getCpf());
        enfermeiro.setNum_carteira(enfermeiroAddDTO.getNum_carteira());
        enfermeiro.setHospital(hospital);
        return repository.save(enfermeiro);
    }
    public Enfermeiro readEnfermeiro(Integer id){
        Optional<Enfermeiro> optionalEnfermeiro = repository.findById(id);
        if(optionalEnfermeiro.isPresent()){
            return optionalEnfermeiro.get();
        } else{
            throw new RuntimeException("Enfermeiro não encontrado");
        }
    }
    public Enfermeiro updateEnfermeiro(Integer id, EnfermeiroAddDTO enfermeiroDTO) {
        Enfermeiro enfermeiro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermeiro não encontrado"));
        enfermeiro.setNome(enfermeiroDTO.getNome());
        enfermeiro.setIdade(enfermeiroDTO.getIdade());
        enfermeiro.setCpf(enfermeiroDTO.getCpf());
        enfermeiro.setNum_carteira(enfermeiroDTO.getNum_carteira());
        return repository.save(enfermeiro);
    }
    public void deleteEnfermeiro(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else{
            throw new RuntimeException("Enfermeiro não encontrado");
        }
    }
}