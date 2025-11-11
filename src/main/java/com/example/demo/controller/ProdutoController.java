package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/novo")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto novo = produtoService.criarProduto(produto);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarProduto(@RequestBody Produto produto) {
        try {
            produtoService.atualizarProduto(produto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable int id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro: " + e.getMessage());
        }
    }
}
