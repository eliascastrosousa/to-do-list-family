package com.eliascastro.dev.todolistfamily.model.tarefa;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAtualizaTarefa(Long id,

                                  String titulo,

                                  String descricao,

                                  @Future
                                  @JsonAlias({"data_conclusao", "dataConclusao"})
                                  LocalDateTime dataConclusao,

                                  Status status) {
}
