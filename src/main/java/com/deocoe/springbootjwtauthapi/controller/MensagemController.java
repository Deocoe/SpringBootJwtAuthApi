package com.deocoe.springbootjwtauthapi.controller;

import com.deocoe.springbootjwtauthapi.service.MensagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/testando")
    public String mensagem() {
        return mensagemService.obterMensagem();
    }


}
