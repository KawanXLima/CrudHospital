package com.system.hospital.service;

import com.system.hospital.model.entity.Relatorio;
import com.system.hospital.model.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public Relatorio createRelatorio(Relatorio relatorio){
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
            findedRelatorio.setEnfermeiro(relatorio.getEnfermeiro());
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
