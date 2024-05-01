package com.eliascastro.dev.todolistfamily.model.tarefa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Page<Tarefa> findAllByAtivoTrue(Pageable paginacao);
    @Query("""
            select t.ativo
            from Tarefa t
            where
            t.id = :id
            """)
    Boolean findAtivoById(Long id);


}
