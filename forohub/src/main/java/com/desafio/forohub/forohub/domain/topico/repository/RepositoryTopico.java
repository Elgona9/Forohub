package com.desafio.forohub.forohub.domain.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.forohub.forohub.domain.topico.Estado;
import com.desafio.forohub.forohub.domain.topico.Topico;

@Repository
public interface RepositoryTopico extends JpaRepository<Topico, Long> {

    @SuppressWarnings("null")
    Page<Topico> findAll(Pageable pageable);

    Page<Topico> findAllByEstadoIsNot(Estado estado, Pageable pageable);

    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Topico findByTitulo(String titulo);
}
