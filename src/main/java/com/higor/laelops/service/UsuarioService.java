package com.higor.laelops.service;

import com.higor.laelops.model.Usuario;
import com.higor.laelops.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public Usuario localizarOuCriarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseGet(() -> usuarioRepository.save(
                Usuario.builder()
                        .email(email)
                        .emailVerificado(false)
                        .build()
        ));
    }
}


