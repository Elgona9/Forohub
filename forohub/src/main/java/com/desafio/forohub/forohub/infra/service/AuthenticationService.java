package com.desafio.forohub.forohub.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.forohub.forohub.domain.usuario.repository.RepositoryUsuario;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private RepositoryUsuario usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username);
    }
}
