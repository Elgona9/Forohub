package com.desafio.forohub.forohub.domain.respuesta.validation.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.respuesta.dto.CrearRespuestaDTO;
import com.desafio.forohub.forohub.domain.usuario.repository.RepositoryUsuario;

@Component
public class RespuestaUsuarioValida implements ValidarRespuestaCreada{

    @Autowired
    private RepositoryUsuario repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId());

        if(!usuarioExiste){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();

        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}
