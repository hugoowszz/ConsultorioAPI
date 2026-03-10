package com.saude.consultorioapi;

public class ReembolsoNaoAutorizadoException extends RuntimeException
{
    private static final long SerialVersionUID = 1L;

    public ReembolsoNaoAutorizadoException(String message) {
        super(message);
    }
}
