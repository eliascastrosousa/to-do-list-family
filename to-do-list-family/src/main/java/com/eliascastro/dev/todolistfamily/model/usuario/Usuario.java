package com.eliascastro.dev.todolistfamily.model.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String login;
    private String senha;
    @Column(name = "created_at")
    private LocalDateTime dataCriacao;
    private Boolean ativo = true;


    public Usuario(DadosCadastroUsuario dados, String senhaBCrypt) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.login = dados.login();
        this.senha = senhaBCrypt;
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarInformacoes(DadosAtualizaUsuario dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.sobrenome() != null){
            this.sobrenome = dados.sobrenome();
        }

    }

    public void arquivarInformacao() {
        this.ativo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
