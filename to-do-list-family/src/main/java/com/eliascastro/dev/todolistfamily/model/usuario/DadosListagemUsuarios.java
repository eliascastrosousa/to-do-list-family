package com.eliascastro.dev.todolistfamily.model.usuario;


public record DadosListagemUsuarios(String nome, String email, String login) {
    public DadosListagemUsuarios(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getLogin());
    }

}