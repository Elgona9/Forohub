package com.desafio.forohub.forohub.domain.topico.validation.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.topico.dto.CrearTopicoDTO;
import com.desafio.forohub.forohub.domain.usuario.repository.RepositoryUsuario;

@Component
public class ValidarTopicoUsuario implements ValidarTopicoCreado{

    @Autowired
    private RepositoryUsuario repository;

    @Override
    public void validate(CrearTopicoDTO data) {
        var existeUsuario = repository.existsById(data.usuarioId());
        if (!existeUsuario) {
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().getEnabled();
        if (!usuarioHabilitado) {
            throw new ValidationException("Este usuario fue deshabiliado.");
        }
    }
}
