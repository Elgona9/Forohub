package com.desafio.forohub.forohub.domain.curso.dto;

import com.desafio.forohub.forohub.domain.curso.Categoria;

public record ActualizarCursoDTO(
        String name,
        Categoria categoria,
        Boolean activo) {
}
