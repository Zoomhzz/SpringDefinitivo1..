package com.example.Revisao3.service;

import com.example.Revisao3.model.ProdutoModel;
import com.example.Revisao3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public ProdutoModel salvar(ProdutoModel produto) {
        // Se quiser validar se já existe um produto com o mesmo nome:
        return repository.save(produto);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        produto.setId(id);
        return repository.save(produto);
    }
}