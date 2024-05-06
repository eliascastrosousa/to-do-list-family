package com.eliascastro.dev.todolistfamily.model.tarefa;

import com.eliascastro.dev.todolistfamily.model.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoTarefa(Long id,
                                      String titulo,

                                      String descricao,

                                      LocalDateTime dataCriacao,

                                      LocalDateTime dataConclusao,

                                      Status status) {
    public DadosDetalhamentoTarefa(Tarefa tarefa) {
        this(tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataCriacao(),
                tarefa.getDataConclusao(),
                tarefa.getStatus()

                );
    }
}
