package com.desafio.forohub.forohub.domain.topico.validation.update;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.curso.repository.RepositoryCurso;
import com.desafio.forohub.forohub.domain.topico.dto.ActualizarTopicoDTO;

@Component
public class ValidarCursoActualizado implements ValidarTopicoActualizado{

    @Autowired
    private RepositoryCurso repository;

    @Override
    public void validate(ActualizarTopicoDTO data) {
        if(data.cursoId() != null){
            var ExisteCurso = repository.existsById(data.cursoId());
            if (!ExisteCurso){
                throw new ValidationException("Este curso no existe");
            }

            var cursoHabilitado = repository.findById(data.cursoId()).get().getActivo();
            if(!cursoHabilitado){
                throw new ValidationException("Este curso no esta disponible en este momento.");
            }
        }

    }
}
