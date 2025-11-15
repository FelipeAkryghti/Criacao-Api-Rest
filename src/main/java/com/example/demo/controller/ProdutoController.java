package com.example.demo.controller;

import com.example.demo.model.entity.Produto;
import com.example.demo.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping("/novo")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto salvo = produtoService.novoProduto(produto);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarProduto(@RequestBody Produto produto) {
        boolean atualizado = produtoService.atualizarProduto(produto);
        if (atualizado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable long id) {
        boolean deletado = produtoService.deletarProduto(id);
        if (deletado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
}
