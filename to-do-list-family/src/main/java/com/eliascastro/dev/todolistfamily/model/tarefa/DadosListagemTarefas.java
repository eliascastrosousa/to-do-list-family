package com.eliascastro.dev.todolistfamily.model.tarefa;

public record DadosListagemTarefas(String titulo,

                                   String descricao,

                                   Status status ) {
    public DadosListagemTarefas(Tarefa tarefa){
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus());
    }
}
