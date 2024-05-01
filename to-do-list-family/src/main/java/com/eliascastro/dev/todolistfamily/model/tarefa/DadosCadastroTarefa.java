package com.eliascastro.dev.todolistfamily.model.tarefa;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DadosCadastroTarefa(Long id,
                                      @NotBlank
                                      String titulo,
                                      @NotBlank
                                      String descricao,

                                      @Future
                                      @JsonAlias({"data_conclusao", "dataConclusao"})
                                      LocalDateTime dataConclusao,

                                      Status status
                                  ) {
}
