package io.github.rikinho.produtosapi.exception;

public class PrecoInvalidoException extends RuntimeException {
    public PrecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
