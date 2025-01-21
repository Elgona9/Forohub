package com.desafio.forohub.forohub.domain.respuesta.validation.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.respuesta.dto.CrearRespuestaDTO;
import com.desafio.forohub.forohub.domain.topico.Estado;
import com.desafio.forohub.forohub.domain.topico.repository.RepositoryTopico;

@Component
public class RespuestaTopicoValida implements ValidarRespuestaCreada{

    @Autowired
    private RepositoryTopico repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var topicoExiste = repository.existsById(data.topicoId());

        if (!topicoExiste){
            throw new ValidationException("Este topico no existe.");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if(topicoAbierto != Estado.OPEN){
            throw new ValidationException("Este topico no esta abierto.");
        }

    }
}
