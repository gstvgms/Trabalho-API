package com.trabalho.api_demo.controller;

import com.trabalho.api_demo.model.LivroEntity;
import com.trabalho.api_demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroEntity> createLivro(@RequestBody LivroEntity livro) {
        LivroEntity createdLivro = livroService.save(livro);
        return ResponseEntity.ok(createdLivro);
    }

    @GetMapping
    public List<LivroEntity> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroEntity> getLivroById(@PathVariable Long id) {
        return livroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroEntity> updateLivro(@PathVariable Long id, @RequestBody LivroEntity livro) {
        return livroService.findById(id)
                .map(livroEntity -> {
                    livro.setId(livroEntity.getId());
                    return ResponseEntity.ok(livroService.save(livro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar")
    public List<LivroEntity> filterLivros(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Boolean available,
            @RequestParam(required = false) Integer rating) {
        if (genre != null) {
            return livroService.findByGenre(genre);
        } else if (available != null) {
            return livroService.findByAvailable(available);
        } else if (rating != null) {
            return livroService.findByRating(rating);
        } else {
            return livroService.findAll();
        }
    }
}
