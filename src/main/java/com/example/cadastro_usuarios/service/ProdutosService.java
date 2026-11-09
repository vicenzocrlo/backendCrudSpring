package com.example.cadastro_usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.cadastro_usuarios.model.Produtos;
import com.example.cadastro_usuarios.repository.ProdutosRepository;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<Produtos> listarTodos() {
        return produtosRepository.findAll(); // SELECT * FROM usuario
    }

    public Produtos salvar(Produtos produtos) {
        produtos.setId(null); // garante que o POST sempre cria um novo registro
        return produtosRepository.save(produtos); // INSERT INTO usuario (nome, email)
    }

    public Produtos buscarPorId(Long id) {
        return produtosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado: id " + id));
    }

    public Produtos atualizar(Long id, Produtos novo) {
        Produtos existente = buscarPorId(id); // devolve 404 se o id não existir

        existente.setNome(novo.getNome());
        existente.setCategoria(novo.getCategoria());
        existente.setValor(novo.getValor());
        existente.setQuantidade(novo.getQuantidade());

        return produtosRepository.save(existente); // UPDATE usuario SET ... WHERE id = ?
    }

    public void excluir(Long id) {
        if (!produtosRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Produto não encontrado: id " + id);
        }
        produtosRepository.deleteById(id); // DELETE FROM usuario WHERE id = ?
    }
}
