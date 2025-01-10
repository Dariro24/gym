package com.gym.services;

import com.gym.models.Promocion;
import com.gym.repositories.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository repository;

    public List<Promocion> getAllPromociones() {
        return repository.findAll();
    }

    public Optional<Promocion> getPromocionById(Long id) {
        return repository.findById(id);
    }

    public Promocion createPromocion(Promocion promocion) {
        return repository.save(promocion);
    }

    public Promocion updatePromocion(Long id, Promocion updatedPromocion) {
        return repository.findById(id).map(promocion -> {
            promocion.setNombre(updatedPromocion.getNombre());
            promocion.setDescripcion(updatedPromocion.getDescripcion());
            promocion.setFechaInicio(updatedPromocion.getFechaInicio());
            promocion.setFechaFin(updatedPromocion.getFechaFin());
            promocion.setUpdatedAt(updatedPromocion.getUpdatedAt());
            return repository.save(promocion);
        }).orElseThrow(() -> new RuntimeException("Promocion no encontrada"));
    }

    public void deletePromocion(Long id) {
        repository.deleteById(id);
    }
}