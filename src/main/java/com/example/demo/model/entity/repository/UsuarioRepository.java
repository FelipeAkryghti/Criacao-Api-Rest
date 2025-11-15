package com.example.demo.model.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findAllByNome(String nome);   
}
