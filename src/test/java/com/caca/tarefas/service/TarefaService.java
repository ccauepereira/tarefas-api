package com.caca.tarefas.service;
import com.caca.tarefas.model.Tarefa;
import com.caca.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private static int contadorId = 1;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public void criar(String titulo) {
        int idGerado = contadorId;
        contadorId++;

        Tarefa novaTarefa = new Tarefa(idGerado, titulo);
        tarefaRepository.salvar(novaTarefa);
    }

    public Tarefa buscar(int id) {
        return tarefaRepository.buscarPorId(id);
    }

    public List<Tarefa> listar(){
        return tarefaRepository.listarTodas();
    }

    public void concluir(int id){
        Tarefa tarefa = tarefaRepository.buscarPorId(id);
        tarefa.setConcluida(true);
        tarefaRepository.atualizar(tarefa);
    }

    public void deletar(int id){
        tarefaRepository.deletar(id);
    }

}

