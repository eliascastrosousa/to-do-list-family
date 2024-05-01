package com.eliascastro.dev.todolistfamily.model.tarefa;

import java.time.LocalDateTime;

public record DadosDetalhamentoTarefa(String titulo,

                                      String descricao,

                                      LocalDateTime dataCriacao,

                                      LocalDateTime dataConclusao,

                                      Status status) {
    public DadosDetalhamentoTarefa(Tarefa tarefa) {
        this(tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataCriacao(),
                tarefa.getDataConclusao(),
                tarefa.getStatus()
                );
    }
}
