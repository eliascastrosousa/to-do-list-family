package com.eliascastro.dev.todolistfamily.model.usuario;

public record DadosDetalhamentoUsuario(String nome,
                                       String sobrenome,
                                       String email,
                                       String login) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getEmail(),
                usuario.getLogin()
        );
    }

}
