package com.desafio.forohub.forohub.domain.respuesta.validation.update;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.forohub.forohub.domain.respuesta.Respuesta;
import com.desafio.forohub.forohub.domain.respuesta.dto.ActualizarRespuestaDTO;
import com.desafio.forohub.forohub.domain.respuesta.repository.RepositoryRespuesta;
import com.desafio.forohub.forohub.domain.topico.Estado;
import com.desafio.forohub.forohub.domain.topico.repository.RepositoryTopico;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada {

    @Autowired
    private RepositoryRespuesta respuestaRepository;

    @Autowired
    private RepositoryTopico topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}
