package com.gym.repositories;

import com.gym.models.ClaseServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseServicioRepository extends JpaRepository<ClaseServicio, Long> {
    // Métodos personalizados opcionales
}