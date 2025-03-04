package io.github.rikinho.produtosapi.exception;


public class DescricaoInvalidaException extends RuntimeException {
    public DescricaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
