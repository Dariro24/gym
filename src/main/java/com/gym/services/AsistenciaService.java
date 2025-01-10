package com.gym.services;

import com.gym.models.Asistencia;
import com.gym.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia saveAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public void deleteAsistencia(Long id) {
        asistenciaRepository.deleteById(id);
    }
}