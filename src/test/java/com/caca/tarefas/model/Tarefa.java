package com.caca.tarefas.model;

public class Tarefa {
    private int id;
    private String titulo;
    private boolean concluida;

    public Tarefa(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setConcluida(boolean concluida){
        this.concluida = concluida;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString(){
        String r;
        r = "\n|Tarefa: "+id+
                "|Titulo: "+titulo+
                "|Concluida: "+concluida;
        return r;
    }
}
