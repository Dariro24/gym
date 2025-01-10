package com.gym.repositories;

import com.gym.models.ClienteFrecuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteFrecuenteRepository extends JpaRepository<ClienteFrecuente, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}