package com.trabalho.api_demo.repository;

import com.trabalho.api_demo.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findByAge(Integer age);
    List<UsuarioEntity> findByActive(boolean active);
    List<UsuarioEntity> findByEmail(String email);
}
