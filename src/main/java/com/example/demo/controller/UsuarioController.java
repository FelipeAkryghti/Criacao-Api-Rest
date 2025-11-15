package com.example.demo.controller;

import com.example.demo.model.entity.Usuario;
import com.example.demo.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/novo")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario salvo = usuarioService.novoUsuario(usuario);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {
        boolean atualizado = usuarioService.atualizarUsuario(usuario);
        if (atualizado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable long id) {
        boolean deletado = usuarioService.deletarUsuario(id);
        if (deletado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

}
