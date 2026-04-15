package com.example.Revisao3.controller;

import com.example.Revisao3.model.FuncionarioModel;
import com.example.Revisao3.repository.FuncionarioRepository;
import com.example.Revisao3.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioModel> listar() {
        return service.listarTodos();
    } // FECHE A CHAVE AQUI

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionario) {
        service.salvar(funcionario); // ADICIONE O PREFIXO 'service'
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionário salvo com sucesso"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atulizar(
            @PathVariable Long id,
            @RequestBody FuncionarioModel funcionario) {
        service.atualizarFuncionario(id, funcionario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Funcionário atualizado com sucesso."));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Funcionário excluido com sucesso."));
    }
}