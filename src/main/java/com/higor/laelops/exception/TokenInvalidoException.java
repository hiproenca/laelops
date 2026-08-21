package com.higor.laelops.exception;

public class TokenInvalidoException extends RuntimeException {
    public TokenInvalidoException() {
        super( "Token inválido ou expirado!");
    }
}

