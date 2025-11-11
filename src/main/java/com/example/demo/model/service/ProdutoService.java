package com.example.demo.model.service;

import com.example.demo.model.Produto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private int id = 0;

    public Produto criarProduto(Produto produto) {
        System.out.println("Recebendo produto: " + produto);
        produto.setId(++id);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public boolean atualizarProduto(Produto produto) throws Exception {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                return true;
            }
        }
        throw new Exception("Produto com id: " + produto.getId() + " não encontrado");
    }

    public boolean deletarProduto(int id) throws Exception {
        boolean deletou = produtos.removeIf(p -> p.getId() == id);
        if (deletou) {
            return true;
        } else {
            throw new Exception("Produto com id: " + id + " não encontrado");
        }
    }
}
