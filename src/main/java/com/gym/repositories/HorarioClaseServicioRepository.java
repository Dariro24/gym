package com.gym.repositories;

import com.gym.models.HorarioClaseServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioClaseServicioRepository extends JpaRepository<HorarioClaseServicio, Long> {
    // Métodos adicionales personalizados si los necesitas
}