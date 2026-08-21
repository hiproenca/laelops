package com.higor.laelops.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MagicLinkRequestDTO(
        @Email(message= "E-mail em formato inválido!")
        @NotBlank(message= "O E-mail é obrigatório!")
        String email) {

}
