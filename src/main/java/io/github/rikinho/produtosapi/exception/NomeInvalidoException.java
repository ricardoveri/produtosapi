package io.github.rikinho.produtosapi.exception;

import org.aspectj.bridge.IMessage;

public class NomeInvalidoException extends RuntimeException{
    public NomeInvalidoException(String mensagem) {
        super(mensagem);
    }
}