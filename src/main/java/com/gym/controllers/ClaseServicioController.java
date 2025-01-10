package com.gym.controllers;

import com.gym.models.ClaseServicio;
import com.gym.services.ClaseServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseServicioController {

    @Autowired
    private ClaseServicioService service;

    @GetMapping
    public List<ClaseServicio> getAllClases() {
        return service.getAllClases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseServicio> getClaseById(@PathVariable Long id) {
        return service.getClaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClaseServicio createClase(@RequestBody ClaseServicio claseServicio) {
        return service.createClase(claseServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseServicio> updateClase(@PathVariable Long id, @RequestBody ClaseServicio claseServicio) {
        try {
            ClaseServicio updatedClase = service.updateClase(id, claseServicio);
            return ResponseEntity.ok(updatedClase);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        service.deleteClase(id);
        return ResponseEntity.noContent().build();
    }
}