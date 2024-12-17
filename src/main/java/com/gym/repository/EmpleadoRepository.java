package com.gym.repository;

import com.gym.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Métodos personalizados si los necesitas
}