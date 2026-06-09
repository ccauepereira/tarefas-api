package com.caca.tarefas.repository;
import com.caca.tarefas.exception.TarefaNaoEncontradaException;
import com.caca.tarefas.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTarefaRepository implements TarefaRepository{
    private HashMap<Integer, Tarefa> tarefas = new HashMap<>();

    @Override
    public void salvar(Tarefa t) {
        tarefas.put(t.getId(), t);
    }

    @Override
    public Tarefa buscarPorId(int id) {
        if(!tarefas.containsKey(id)){
            throw new TarefaNaoEncontradaException(id);
        }
        return tarefas.get(id);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas.values());
    }

    @Override
    public void atualizar(Tarefa t) {
        if(!tarefas.containsKey(t.getId())){
            throw new TarefaNaoEncontradaException(t.getId());
        }
        tarefas.put(t.getId(),t);
    }

    @Override
    public void deletar(int id) {
        if(!tarefas.containsKey(id)){
            throw new TarefaNaoEncontradaException(id);
        }
        tarefas.remove(id);
    }
}

