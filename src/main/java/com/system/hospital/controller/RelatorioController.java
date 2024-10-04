package com.system.hospital.controller;

import com.system.hospital.model.DTOs.RelatorioAddDTO;
import com.system.hospital.model.entity.Relatorio;
import com.system.hospital.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
    @Autowired
    private RelatorioService relatorioService;

    @PostMapping
    public ResponseEntity<Relatorio> createRelatorio(@RequestBody RelatorioAddDTO relatorioAddDTO){
        Relatorio savedRelatorio = relatorioService.createRelatorio(relatorioAddDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRelatorio.getId()).toUri();
        return ResponseEntity.created(location).body(savedRelatorio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> readRelatorio(@PathVariable Integer id){
        try{
            Relatorio relatorio = relatorioService.readRelatorio(id);
            return ResponseEntity.ok(relatorio);
        } catch (RuntimeException e){
            System.err.println("Erro: "+ e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> updateRelatorio(@PathVariable Integer id, @RequestBody Relatorio relatorio){
        try{
            Relatorio updatedRelatorio = relatorioService.updateRelatorio(id, relatorio);
            return ResponseEntity.ok(updatedRelatorio);
        } catch (RuntimeException e){
            System.err.println("Erro: "+ e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Integer id){
        try{
            relatorioService.deleteRelatorio(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            System.err.println("Erro: "+e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
