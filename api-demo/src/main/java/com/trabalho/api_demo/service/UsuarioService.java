package com.trabalho.api_demo.service;

import com.trabalho.api_demo.model.UsuarioEntity;
import com.trabalho.api_demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioEntity> findByAge(Integer age) {
        return usuarioRepository.findByAge(age);
    }

    public List<UsuarioEntity> findByActive(boolean active) {
        return usuarioRepository.findByActive(active);
    }

    public List<UsuarioEntity> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
