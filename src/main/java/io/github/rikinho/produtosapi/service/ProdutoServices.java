package io.github.rikinho.produtosapi.service;

import io.github.rikinho.produtosapi.model.Produto;
import io.github.rikinho.produtosapi.repository.ProdutoRepository;
import io.github.rikinho.produtosapi.validator.ValidarProduto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServices {

    private final ProdutoRepository produtoRepository;
    private final ValidarProduto validarProduto;

    public ProdutoServices(ProdutoRepository produtoRepository, ValidarProduto validarProduto) {
        this.produtoRepository = produtoRepository;
        this.validarProduto = validarProduto;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvar(@RequestBody Produto produto) {
        validarProduto.validar(produto);
        produto.gerarDataPostagem();
        produtoRepository.save(produto);
        return produto;
    }

    public Produto obterPorId(@PathVariable("id") UUID id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletar(@PathVariable UUID id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(@PathVariable("id") UUID id, @RequestBody Produto novosAtributos) {
        Produto produto = obterPorId(id);
        validarProduto.validar(novosAtributos);
        produto.setNome(novosAtributos.getNome());
        produto.setDescricao(novosAtributos.getDescricao());
        produto.setQuantidade(novosAtributos.getQuantidade());
        produto.setDataPostagem(LocalDate.now());
        produto.setPreco(novosAtributos.getPreco());
        return produtoRepository.save(produto);
    }
}
