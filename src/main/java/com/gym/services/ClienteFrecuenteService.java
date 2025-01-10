package com.gym.services;

import com.gym.models.ClienteFrecuente;
import com.gym.repositories.ClienteFrecuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteFrecuenteService {

    @Autowired
    private ClienteFrecuenteRepository repository;

    public List<ClienteFrecuente> findAll() {
        return repository.findAll();
    }

    public Optional<ClienteFrecuente> findById(Long id) {
        return repository.findById(id);
    }

    public ClienteFrecuente save(ClienteFrecuente clienteFrecuente) {
        return repository.save(clienteFrecuente);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
