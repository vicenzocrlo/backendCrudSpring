package com.example.cadastro_usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_usuarios.model.Produtos;
import com.example.cadastro_usuarios.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    // GET - lista todos
    @GetMapping
    public List<Produtos> listarTodos() {
        return produtosService.listarTodos();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Produtos buscar(@PathVariable Long id) {
        return produtosService.buscarPorId(id);
    }

    // POST - cria
    @PostMapping
    public Produtos criar(@RequestBody Produtos produtos) {
        return produtosService.salvar(produtos);
    }

    // PUT - atualiza
    @PutMapping("/{id}")
    public Produtos atualizar(@PathVariable Long id, @RequestBody Produtos produtos) {
        return produtosService.atualizar(id, produtos);
    }

    // DELETE - exclui
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtosService.excluir(id);
    }
}
