package com.gym.controllers;

import com.gym.models.Promocion;
import com.gym.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    @Autowired
    private PromocionService service;

    @GetMapping
    public List<Promocion> getAllPromociones() {
        return service.getAllPromociones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocion> getPromocionById(@PathVariable Long id) {
        return service.getPromocionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Promocion createPromocion(@RequestBody Promocion promocion) {
        return service.createPromocion(promocion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> updatePromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        try {
            Promocion updatedPromocion = service.updatePromocion(id, promocion);
            return ResponseEntity.ok(updatedPromocion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long id) {
        service.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }
}