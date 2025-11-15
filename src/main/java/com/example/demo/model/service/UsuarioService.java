package com.example.demo.model.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Usuario;
import com.example.demo.model.entity.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        Iterable<Usuario> iterable = usuarioRepository.findAll();
        List<Usuario> usuarios = new ArrayList<>();
        for (Usuario u : iterable) {
            usuarios.add(u);
        }
        return usuarios;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getId())) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean deletarUsuario(long id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }

}
