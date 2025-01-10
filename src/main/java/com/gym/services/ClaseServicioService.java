package com.gym.services;

import com.gym.models.ClaseServicio;
import com.gym.repositories.ClaseServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServicioService {

    @Autowired
    private ClaseServicioRepository repository;

    public List<ClaseServicio> getAllClases() {
        return repository.findAll();
    }

    public Optional<ClaseServicio> getClaseById(Long id) {
        return repository.findById(id);
    }

    public ClaseServicio createClase(ClaseServicio claseServicio) {
        return repository.save(claseServicio);
    }

    public ClaseServicio updateClase(Long id, ClaseServicio updatedClase) {
        return repository.findById(id).map(clase -> {
            clase.setNombre(updatedClase.getNombre());
            clase.setDescripcion(updatedClase.getDescripcion());
            clase.setClasificacion(updatedClase.getClasificacion());
            clase.setCondicionesUso(updatedClase.getCondicionesUso());
            clase.setUpdatedAt(updatedClase.getUpdatedAt());
            return repository.save(clase);
        }).orElseThrow(() -> new RuntimeException("ClaseServicio no encontrada"));
    }

    public void deleteClase(Long id) {
        repository.deleteById(id);
    }
}
