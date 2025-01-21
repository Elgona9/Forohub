package com.desafio.forohub.forohub.domain.usuario.validation.create;

import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.usuario.dto.CrearUsuarioDTO;
import com.desafio.forohub.forohub.domain.usuario.repository.RepositoryUsuario;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario{

    @Autowired
    private RepositoryUsuario repository;

    @Override
    public void validate(CrearUsuarioDTO data) {
        var usuarioDuplicado = repository.findByUsername(data.username());
        if(usuarioDuplicado != null){
            throw new ValidationException("Este usuario ya existe.");
        }

        var emailDuplicado = repository.findByEmail(data.email());
        if(emailDuplicado != null){
            throw new ValidationException("Este email ya existe.");
        }
    }
}
