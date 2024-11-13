package com.trabalho.api_demo.service;

import com.trabalho.api_demo.model.LivroEntity;
import com.trabalho.api_demo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroEntity> findAll() {
        return livroRepository.findAll();
    }

    public Optional<LivroEntity> findById(Long id) {
        return livroRepository.findById(id);
    }

    public LivroEntity save(LivroEntity livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    public List<LivroEntity> findByGenre(String genre) {
        return livroRepository.findByGenre(genre);
    }

    public List<LivroEntity> findByAvailable(boolean available) {
        return livroRepository.findByAvailable(available);
    }

    public List<LivroEntity> findByRating(Integer rating) {
        return livroRepository.findByRating(rating);
    }


}
