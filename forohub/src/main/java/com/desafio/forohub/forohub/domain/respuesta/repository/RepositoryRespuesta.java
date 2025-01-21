package com.desafio.forohub.forohub.domain.respuesta.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafio.forohub.forohub.domain.respuesta.Respuesta;

@Repository
public interface RepositoryRespuesta extends JpaRepository<Respuesta, Long> {
	
    Page<Respuesta> findAllByTopicoId(Long topicoId, Pageable pageable);

    Page<Respuesta> findAllByUsuarioId(Long usuarioId, Pageable pageable);

    Respuesta getReferenceByTopicoId(Long id);

    @SuppressWarnings("null")
    Respuesta getReferenceById(Long id);
}
