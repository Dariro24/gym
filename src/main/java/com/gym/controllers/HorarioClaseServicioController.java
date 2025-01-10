package com.gym.controllers;

import com.gym.models.HorarioClaseServicio;
import com.gym.services.HorarioClaseServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioClaseServicioController {

    @Autowired
    private HorarioClaseServicioService service;

    @GetMapping
    public List<HorarioClaseServicio> getAllHorarios() {
        return service.getAllHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioClaseServicio> getHorarioById(@PathVariable Long id) {
        return service.getHorarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HorarioClaseServicio createHorario(@RequestBody HorarioClaseServicio horario) {
        return service.createHorario(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioClaseServicio> updateHorario(@PathVariable Long id, @RequestBody HorarioClaseServicio horario) {
        try {
            HorarioClaseServicio updatedHorario = service.updateHorario(id, horario);
            return ResponseEntity.ok(updatedHorario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        service.deleteHorario(id);
        return ResponseEntity.noContent().build();
    }
}
