package com.trabalho.api_demo.controller;

import com.trabalho.api_demo.model.UsuarioEntity;
import com.trabalho.api_demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioEntity createUsuario(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> updateUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        return usuarioService.findById(id)
                .map(usuarioEntity -> {
                    usuario.setId(usuarioEntity.getId());
                    return ResponseEntity.ok(usuarioService.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar")
    public List<UsuarioEntity> filterUsuarios(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String email){
        if (age != null) {
            return usuarioService.findByAge(age);
        } else if (active != null) {
            return usuarioService.findByActive(active);
        } else if (email != null) {
            return usuarioService.findByEmail(email);
        } else {
            return usuarioService.findAll();
        }
    }
}
