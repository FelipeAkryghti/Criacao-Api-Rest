package com.example.demo.model.service;

import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();
    private int id = 0;

    public Usuario criarUsuario(Usuario usuario) {
        System.out.println("Recebendo usuário: " + usuario);
        usuario.setId(++id);
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public boolean atualizarUsuario(Usuario usuario) throws Exception {

        boolean atualizado = false;
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());
                return true;
            }
        }
         if(!atualizado){
            throw new Exception("Usuário com id: " + id + " não encontrado");
         }

         return atualizado;
    }

    public boolean deletarUsuario(int id) throws Exception {
        boolean deletou = usuarios.removeIf(u -> u.getId() == id);

        if(deletou) {
            return true;
        } else {
            throw new Exception("Usuário com id: " + id + " não encontrado");
        }
    }

} 
