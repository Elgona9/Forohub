package com.desafio.forohub.forohub.domain.usuario.validation.update;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.usuario.dto.ActualizarUsuarioDTO;
import com.desafio.forohub.forohub.domain.usuario.repository.RepositoryUsuario;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario {

    @Autowired
    private RepositoryUsuario repository;

    @Override
    public void validate(ActualizarUsuarioDTO data) {
        if(data.email() != null){
            var emailDuplicado = repository.findByEmail(data.email());
            if(emailDuplicado != null){
                throw new ValidationException("Este email ya esta en uso");
            }
        }
    }
}
