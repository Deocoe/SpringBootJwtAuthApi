package com.deocoe.springbootjwtauthapi.dto;

import com.deocoe.springbootjwtauthapi.model.Usuario;

public class UsuarioResponseDTO {

    private Long id;
    private String username;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}


