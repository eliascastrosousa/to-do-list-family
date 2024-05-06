package com.eliascastro.dev.todolistfamily.model.tarefa;

import com.eliascastro.dev.todolistfamily.model.ValidacaoException;
import com.eliascastro.dev.todolistfamily.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroTarefa {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public DadosDetalhamentoTarefa cadastrar(DadosCadastroTarefa dados){
        if (!repository.existsById(dados.usuarioId())) {
            throw new ValidacaoException("Id do Usuario informado não existe");
        }
        var usuario = repository.findById(dados.usuarioId()).get();
        var tarefa = new Tarefa(dados.titulo(), dados.descricao(), dados.dataConclusao(), dados.status(), usuario);
        tarefaRepository.save(tarefa);
        return new DadosDetalhamentoTarefa(tarefa);
    }
}
