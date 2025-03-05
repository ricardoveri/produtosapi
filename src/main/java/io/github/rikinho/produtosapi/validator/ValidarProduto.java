package io.github.rikinho.produtosapi.validator;

import io.github.rikinho.produtosapi.exception.*;
import io.github.rikinho.produtosapi.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ValidarProduto {
    public void validar(Produto produto) {
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new NomeInvalidoException("O nome do produto é obrigatório.");
        }

        if (produto.getDescricao() != null && produto.getDescricao().length() > 300) {
            throw new DescricaoInvalidaException("A descricao deve ter no máximo 300 caracteres.");
        }

        if (produto.getQuantidade() < 0) {
            throw new QuantidadeInvalidaException("A quantidade do produto deve ser maior ou igual a zero.");
        }

        if (produto.getPreco() == null || produto.getPreco() < 0) {
            throw new PrecoInvalidoException("O preço do produto deve ser maior ou igual a zero.");
        }
    }
}