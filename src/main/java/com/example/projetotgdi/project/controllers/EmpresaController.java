package com.example.projetotgdi.project.controllers;

import com.example.projetotgdi.project.database.repositories.EmpresaRepository;
import com.example.projetotgdi.project.database.schemas.EmpresaSchema;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmpresaController {

   
    private EmpresaRepository empresaRepository;

    @GetMapping
    public ResponseEntity<List<EmpresaSchema>> getEmpresas() {
        List<EmpresaSchema> empresas = empresaRepository.findAll();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaSchema> getEmpresa(@PathVariable String id) {
        EmpresaSchema empresa = empresaRepository.findById(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaSchema> createEmpresa(@RequestBody EmpresaSchema empresa) {
        empresaRepository.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaSchema> updateEmpresa(@PathVariable String id, @RequestBody EmpresaSchema empresaAtualizada) {
        EmpresaSchema empresaExistente = empresaRepository.findById(id);
        if (empresaExistente != null) {
            empresaRepository.findOneAndUpdate(id, empresaAtualizada);
            return ResponseEntity.ok(empresaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable String id) {
        EmpresaSchema empresaExistente = empresaRepository.findById(id);
        if (empresaExistente != null) {
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
