package com.example.demo.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;

    // Construtor vazio necessário para deserialização JSON
    public Usuario() {
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + "]";
    }
}
