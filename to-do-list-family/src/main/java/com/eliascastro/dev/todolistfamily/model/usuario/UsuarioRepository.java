package com.eliascastro.dev.todolistfamily.model.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

//    @Query("""
//            select u.ativo
//            from usuarios u
//            where
//            u.id = :id
//            """)
//    Boolean findAtivoById(Long id);
}
