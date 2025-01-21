package com.desafio.forohub.forohub.domain.topico.validation.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.topico.dto.CrearTopicoDTO;
import com.desafio.forohub.forohub.domain.topico.repository.RepositoryTopico;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado{

    @Autowired
    private RepositoryTopico topicoRepository;


    @Override
    public void validate(CrearTopicoDTO data) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(data.titulo(), data.mensaje());
        if(topicoDuplicado){
            throw new ValidationException("Este topico ya existe. Revisa /topicos/" + topicoRepository.findByTitulo(data.titulo()).getId());

        }
    }
}
