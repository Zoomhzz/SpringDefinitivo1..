package com.example.Revisao3.controller;

import com.example.Revisao3.model.ProdutoModel;
import com.example.Revisao3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoModel> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ProdutoModel produto) {
        service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produto cadastrado com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        service.atualizar(id, produto);
        return ResponseEntity.ok(Map.of("mensagem", "Produto atualizado com sucesso!"));
    }
}