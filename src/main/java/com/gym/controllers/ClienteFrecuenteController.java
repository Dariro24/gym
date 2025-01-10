package com.gym.controllers;

import com.gym.models.ClienteFrecuente;
import com.gym.services.ClienteFrecuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente-frecuente")
public class ClienteFrecuenteController {

    @Autowired
    private ClienteFrecuenteService service;

    @GetMapping
    public ResponseEntity<List<ClienteFrecuente>> getAll() {
        List<ClienteFrecuente> clientesFrecuentes = service.findAll();
        return ResponseEntity.ok(clientesFrecuentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFrecuente> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteFrecuente> create(@RequestBody ClienteFrecuente clienteFrecuente) {
        ClienteFrecuente savedClienteFrecuente = service.save(clienteFrecuente);
        return ResponseEntity.ok(savedClienteFrecuente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteFrecuente> update(@PathVariable Long id, @RequestBody ClienteFrecuente clienteFrecuente) {
        return service.findById(id)
                .map(existing -> {
                    clienteFrecuente.setIdClienteFrecuente(id);
                    ClienteFrecuente updatedClienteFrecuente = service.save(clienteFrecuente);
                    return ResponseEntity.ok(updatedClienteFrecuente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
