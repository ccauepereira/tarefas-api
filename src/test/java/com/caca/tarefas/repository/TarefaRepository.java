package com.caca.tarefas.repository;
import com.caca.tarefas.model.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa t);
    Tarefa buscarPorId(int id);
    List<Tarefa> listarTodas();
    void atualizar(Tarefa t);
    void deletar(int id);
}
