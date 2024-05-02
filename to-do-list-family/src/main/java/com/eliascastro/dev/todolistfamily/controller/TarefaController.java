package com.eliascastro.dev.todolistfamily.controller;

import com.eliascastro.dev.todolistfamily.model.tarefa.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTarefa dados, UriComponentsBuilder uriBuilder){
        var tarefa = new Tarefa(dados);
        repository.save(tarefa);
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTarefa(tarefa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTarefas>> listarTarefas(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTarefas::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTarefa(@RequestBody @Valid DadosAtualizaTarefa dados){
        var tarefa = repository.getReferenceById(dados.id());
        tarefa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity arquivarTarefa(@PathVariable Long id){
        var tarefa = repository.getReferenceById(id);
        tarefa.arquivarInformacao();
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable Long id){
        var tarefa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

}
