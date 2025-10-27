package com.deocoe.springbootjwtauthapi.controller;

import com.deocoe.springbootjwtauthapi.model.Usuario;
import com.deocoe.springbootjwtauthapi.security.JwtUtil;
import com.deocoe.springbootjwtauthapi.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    private final AuthenticationManager authenticationManager;

    public AuthController(UsuarioService usuarioService, AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), request.get("password"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    request.get("username"),
                    request.get("password")
            );

            authenticationManager.authenticate(authToken);

            String token = JwtUtil.generateToken(request.get("username"));
            return ResponseEntity.ok(Map.of("token", token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Credenciais Inválidas");
        }
    }
}
