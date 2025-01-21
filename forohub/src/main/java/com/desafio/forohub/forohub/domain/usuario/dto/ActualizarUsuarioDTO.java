package com.desafio.forohub.forohub.domain.usuario.dto;

import com.desafio.forohub.forohub.domain.usuario.Rol;

public record ActualizarUsuarioDTO(
        String password,
        Rol rol,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {
}
