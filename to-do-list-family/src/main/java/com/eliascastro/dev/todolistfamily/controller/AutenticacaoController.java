package com.eliascastro.dev.todolistfamily.controller;

import com.eliascastro.dev.todolistfamily.infra.security.DadosTokenJWT;
import com.eliascastro.dev.todolistfamily.infra.security.TokenService;
import com.eliascastro.dev.todolistfamily.model.usuario.DadosAutenticacao;
import com.eliascastro.dev.todolistfamily.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }

}
