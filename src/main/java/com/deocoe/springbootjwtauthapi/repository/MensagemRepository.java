package com.deocoe.springbootjwtauthapi.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem() {
        return "Teste do Repositório";
    }
}
