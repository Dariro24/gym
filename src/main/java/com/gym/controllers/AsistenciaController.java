package com.gym.controllers;

import com.gym.models.Asistencia;
import com.gym.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.getAllAsistencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Long id) {
        Optional<Asistencia> asistencia = asistenciaService.getAsistenciaById(id);
        return asistencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.saveAsistencia(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Long id, @RequestBody Asistencia updatedAsistencia) {
        Optional<Asistencia> existingAsistencia = asistenciaService.getAsistenciaById(id);
        if (existingAsistencia.isPresent()) {
            updatedAsistencia.setIdAsistencia(id);
            asistenciaService.saveAsistencia(updatedAsistencia);
            return ResponseEntity.ok(updatedAsistencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Long id) {
        if (asistenciaService.getAsistenciaById(id).isPresent()) {
            asistenciaService.deleteAsistencia(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
