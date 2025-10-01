package com.deocoe.springbootjwtauthapi.service;

import com.deocoe.springbootjwtauthapi.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;


    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();
    }
}
