package com.higor.laelops.controller;

import com.higor.laelops.dto.MagicLinkRequestDTO;
import com.higor.laelops.dto.MagicLinkResponseDTO;
import com.higor.laelops.service.MagicLinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/magic-link")
@RequiredArgsConstructor
public class MagicLinkController {
    private final MagicLinkService magicLinkService;
    @PostMapping
    public ResponseEntity<MagicLinkResponseDTO> magicLink(@Valid @RequestBody MagicLinkRequestDTO dto){
        magicLinkService.generateMagicLink(dto.email());
        return ResponseEntity.ok(new MagicLinkResponseDTO("Email enviado com sucesso para:" + dto.email()));

    }
    //@GetMapping("/auth/verificar")
    //public ResponseEntity<MagicLinkResponseDTO> verificarToken(@RequestParam = true, String token){
    //}



}
