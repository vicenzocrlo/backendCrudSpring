package com.example.cadastro_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro_usuarios.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
