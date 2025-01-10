package com.gym.services;

import com.gym.models.HorarioClaseServicio;
import com.gym.repositories.HorarioClaseServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioClaseServicioService {

    @Autowired
    private HorarioClaseServicioRepository repository;

    public List<HorarioClaseServicio> getAllHorarios() {
        return repository.findAll();
    }

    public Optional<HorarioClaseServicio> getHorarioById(Long id) {
        return repository.findById(id);
    }

    public HorarioClaseServicio createHorario(HorarioClaseServicio horario) {
        return repository.save(horario);
    }

    public HorarioClaseServicio updateHorario(Long id, HorarioClaseServicio updatedHorario) {
        return repository.findById(id).map(horario -> {
            horario.setClaseServicio(updatedHorario.getClaseServicio());
            horario.setDiaSemana(updatedHorario.getDiaSemana());
            horario.setHoraInicio(updatedHorario.getHoraInicio());
            horario.setHoraFin(updatedHorario.getHoraFin());
            horario.setUpdatedAt(updatedHorario.getUpdatedAt());
            return repository.save(horario);
        }).orElseThrow(() -> new RuntimeException("HorarioClaseServicio no encontrado"));
    }

    public void deleteHorario(Long id) {
        repository.deleteById(id);
    }
}