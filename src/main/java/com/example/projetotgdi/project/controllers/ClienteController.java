package com.example.projetotgdi.project.controllers;

import com.example.projetotgdi.project.database.repositories.ClienteRepository;
import com.example.projetotgdi.project.database.schemas.ClienteSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<ClienteSchema>> getAllClientes() {
        List<ClienteSchema> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteSchema> getClienteById(@PathVariable String id) {
        ClienteSchema cliente = clienteRepository.findById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteSchema> createCliente(@RequestBody ClienteSchema cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.status().body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteSchema> updateCliente(@PathVariable String id,
            @RequestBody ClienteSchema clienteAtualizado) {
        ClienteSchema clienteExistente = clienteRepository.findById(id);
        if (clienteExistente != null) {
            clienteRepository.update(id, clienteAtualizado);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String id) {
        ClienteSchema clienteExistente = clienteRepository.findById(id);
        if (clienteExistente != null) {
            clienteRepository.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}