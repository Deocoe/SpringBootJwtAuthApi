package com.deocoe.springbootjwtauthapi.service;

import com.deocoe.springbootjwtauthapi.dto.RegisterRequestDTO;
import com.deocoe.springbootjwtauthapi.dto.UsuarioResponseDTO;
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

    public UsuarioResponseDTO registrarUsuario(RegisterRequestDTO registerRequest) {
        String senhaCriptografada = passwordEncoder.encode(registerRequest.getPassword());
        Usuario usuario = new Usuario(registerRequest.getUsername(), senhaCriptografada);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuarioSalvo);
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}