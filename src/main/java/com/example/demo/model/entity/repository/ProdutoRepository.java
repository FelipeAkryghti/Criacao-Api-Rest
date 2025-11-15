package com.example.demo.model.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
