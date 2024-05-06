package com.eliascastro.dev.todolistfamily.model.tarefa;

import com.eliascastro.dev.todolistfamily.model.usuario.DadosCadastroUsuario;
import com.eliascastro.dev.todolistfamily.model.usuario.Usuario;
import com.eliascastro.dev.todolistfamily.model.usuario.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
@Table(name = "tarefas")
@Entity(name = "Tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Boolean ativo = true;


    public Tarefa(DadosCadastroTarefa dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = dados.dataConclusao();
        this.status = dados.status();

    }

    public void atualizarInformacoes(DadosAtualizaTarefa dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.status() != null){
            this.status = dados.status();
        }
        if (dados.dataConclusao() != null) {
            this.dataConclusao = dados.dataConclusao();
        }
    }

    public void arquivarInformacao() {
        this.ativo = false;
    }
}
