package com.trabalho.api_demo.repository;

import com.trabalho.api_demo.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    List<LivroEntity> findByGenre(String genre);
    List<LivroEntity> findByAvailable(boolean available);
    List<LivroEntity> findByRating(Integer rating);
}
