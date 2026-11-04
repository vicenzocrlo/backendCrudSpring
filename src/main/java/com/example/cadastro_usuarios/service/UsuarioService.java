package com.example.cadastro_usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.cadastro_usuarios.model.Usuario;
import com.example.cadastro_usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll(); // SELECT * FROM usuario
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setId(null); // garante que o POST sempre cria um novo registro
        return usuarioRepository.save(usuario); // INSERT INTO usuario (nome, email)
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado: id " + id));
    }

    public Usuario atualizar(Long id, Usuario novo) {
        Usuario existente = buscarPorId(id); // devolve 404 se o id não existir

        existente.setNome(novo.getNome());
        existente.setEmail(novo.getEmail());

        return usuarioRepository.save(existente); // UPDATE usuario SET ... WHERE id = ?
    }

    public void excluir(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado: id " + id);
        }
        usuarioRepository.deleteById(id); // DELETE FROM usuario WHERE id = ?
    }
}
