package com.example.demo.model.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Produto;
import com.example.demo.model.entity.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto novoProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        Iterable<Produto> iterable = produtoRepository.findAll();
        List<Produto> produtos = new ArrayList<>();
        for (Produto p : iterable) {
            produtos.add(p);
        }
        return produtos;
    }

    public boolean atualizarProduto(Produto produto) {
        if (!produtoRepository.existsById(produto.getId())) {
            return false;
        }
        produtoRepository.save(produto);
        return true;
    }

    public boolean deletarProduto(long id) {
        if (!produtoRepository.existsById(id)) {
            return false;
        }
        produtoRepository.deleteById(id);
        return true;
    }
}
