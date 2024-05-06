package com.eliascastro.dev.todolistfamily.controller;

import com.eliascastro.dev.todolistfamily.infra.security.TokenService;
import com.eliascastro.dev.todolistfamily.model.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.eliascastro.dev.todolistfamily.model.usuario.UsuarioRepository;
import com.eliascastro.dev.todolistfamily.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){
        if(this.repository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        var senhaBCrypt = encoder.encode(dados.senha());
        Usuario user = new Usuario(dados,senhaBCrypt);
        repository.save(user);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(user));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarios>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuarios::new);
        return ResponseEntity.ok(page);
    }




}
