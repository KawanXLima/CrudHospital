package com.system.hospital.service;

import com.system.hospital.model.DTOs.RelatorioAddDTO;
import com.system.hospital.model.entity.Enfermeiro;
import com.system.hospital.model.entity.Relatorio;
import com.system.hospital.model.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    @Autowired
    private EnfermeiroService service;

    public Relatorio createRelatorio(RelatorioAddDTO relatorioAddDTO){
        Enfermeiro enfermeiro = service.encontrarPorID(relatorioAddDTO.getEnfermeiro_id());
        Relatorio relatorio = new Relatorio();
        relatorio.setObservacao(relatorioAddDTO.getObservacao());
        relatorio.setEnfermeiro(enfermeiro);
        return repository.save(relatorio);
    }

    public Relatorio readRelatorio(Integer id){
        Optional<Relatorio> optionalRelatorio = repository.findById(id);
        if(optionalRelatorio.isPresent()){
            return optionalRelatorio.get();
        } else{
            throw new RuntimeException("Relatório não encontrado");
        }
    }

    public Relatorio updateRelatorio(Integer id, Relatorio relatorio){
        Optional<Relatorio> optionalRelatorio = repository.findById(id);
        if(optionalRelatorio.isPresent()) {
            Relatorio findedRelatorio = optionalRelatorio.get();
            findedRelatorio.setObservacao(relatorio.getObservacao());
            return repository.save(findedRelatorio);
        } else{
            throw new RuntimeException("Relatório não encontrado");
        }
    }

    public void deleteRelatorio(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else{
            throw new RuntimeException("Relatório não encontrado");
        }
    }
}
