package com.gym.repositories;

import com.gym.models.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    // Puedes agregar métodos personalizados si los necesitas
}