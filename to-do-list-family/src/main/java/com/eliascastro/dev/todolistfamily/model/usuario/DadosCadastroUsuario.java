package com.eliascastro.dev.todolistfamily.model.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroUsuario(
        Long id,
        String nome,
        String sobrenome,
        String email,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @Future
        @JsonAlias({"created_at", "dataCriacao"})
        LocalDateTime dataCriacao,
        Boolean ativo
) {



}
