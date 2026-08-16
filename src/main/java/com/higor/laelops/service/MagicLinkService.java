package com.higor.laelops.service;

import com.higor.laelops.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class MagicLinkService {
    private final UsuarioService usuarioService;
    private final StringRedisTemplate redisTemplate;

    public String generateMagicLink(String email){
        Usuario usuario = usuarioService.localizarOuCriarUsuarioPorEmail(email);
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);

        String tokenTexto = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        String hash = criarHash(tokenTexto);
        redisTemplate.opsForValue().set(hash, usuario.getId().toString(), Duration.ofMinutes(15));

        return tokenTexto;
    }

    public String criarHash(String tokenTexto){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(tokenTexto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().withoutPadding().encodeToString(hash);
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Algoritmo SHA-256 indisponível", e);
        }

    }

}
