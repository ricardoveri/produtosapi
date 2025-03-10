package io.github.rikinho.produtosapi.service;

import io.github.rikinho.produtosapi.model.Produto;
import io.github.rikinho.produtosapi.repository.ProdutoRepository;
import io.github.rikinho.produtosapi.validator.ValidarProduto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

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

    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletar(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto novoProduto) {
        Produto produto = obterPorId(id);
        validarProduto.validar(novoProduto);
        produto.setNome(novoProduto.getNome());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setQuantidade(novoProduto.getQuantidade());
        produto.setDataPostagem(LocalDate.now());
        produto.setPreco(novoProduto.getPreco());
        return produtoRepository.save(produto);
    }
}
