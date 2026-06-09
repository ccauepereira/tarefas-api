package com.caca.tarefas.controller;
import com.caca.tarefas.model.Tarefa;
import com.caca.tarefas.service.TarefaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestParam String titulo){
        tarefaService.criar(titulo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listar(){
        List<Tarefa> lista = tarefaService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable int id){
        Tarefa tarefa = tarefaService.buscar(id);
        return ResponseEntity.ok(tarefa);
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable int id){
        tarefaService.concluir(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

