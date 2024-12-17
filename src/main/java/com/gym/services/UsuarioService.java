package com.gym.services;

import com.gym.models.Usuario;
import com.gym.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null) {
            // Comparar las contraseñas
            return usuario.getPassword().equals(password);
        }
        return false;
    }
}