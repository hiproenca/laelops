package com.higor.laelops.config;

import com.higor.laelops.service.MagicLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TesteMagicLink implements CommandLineRunner {
    private final MagicLinkService magicLinkService;
    @Override
    public void run(String ... args) {
        String email = "DanielDefoe@mail.com";
        String token = magicLinkService.generateMagicLink(email);
        String hash = magicLinkService.criarHash(token);

        //System.out.println(">>> Token (vai no link do e-mail): " + token);
        //System.out.println(">>> Hash (chave gravada no Redis): " + hash);


    }
}
