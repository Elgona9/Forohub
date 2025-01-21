package com.desafio.forohub.forohub.domain.curso.dto;

import com.desafio.forohub.forohub.domain.curso.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCursoDTO(
        @NotBlank String name,
        @NotNull Categoria categoria) {
}
