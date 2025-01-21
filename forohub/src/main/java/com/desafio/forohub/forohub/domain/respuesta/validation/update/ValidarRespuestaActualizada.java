package com.desafio.forohub.forohub.domain.respuesta.validation.update;

import com.desafio.forohub.forohub.domain.respuesta.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    void validate(ActualizarRespuestaDTO data, Long respuestaId);
}
