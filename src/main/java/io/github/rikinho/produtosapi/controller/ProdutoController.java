package io.github.rikinho.produtosapi.controller;

import io.github.rikinho.produtosapi.model.Produto;
import io.github.rikinho.produtosapi.repository.ProdutoRepository;
import io.github.rikinho.produtosapi.validator.ValidarProduto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final ValidarProduto validarProduto;

    public ProdutoController(ProdutoRepository produtoRepository, ValidarProduto validarProduto) {
        this.produtoRepository = produtoRepository;
        this.validarProduto = validarProduto;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        validarProduto.validar(produto);
        produto.gerarId();
        produto.gerarDataPostagem();
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        validarProduto.validar(produto);
        produto.setId(id);
        produtoRepository.save(produto);
    }
}
