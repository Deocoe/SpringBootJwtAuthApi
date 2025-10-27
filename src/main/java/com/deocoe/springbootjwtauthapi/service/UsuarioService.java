package com.deocoe.springbootjwtauthapi.service;

import com.deocoe.springbootjwtauthapi.model.Usuario;
import com.deocoe.springbootjwtauthapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrarUsuario(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}