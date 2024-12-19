package com.gym.repositories;

import com.gym.models.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
    // Métodos personalizados si los necesitas
}