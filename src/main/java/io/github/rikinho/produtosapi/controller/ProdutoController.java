package io.github.rikinho.produtosapi.controller;

import io.github.rikinho.produtosapi.model.Produto;
import io.github.rikinho.produtosapi.repository.ProdutoRepository;
import io.github.rikinho.produtosapi.service.ProdutoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServices produtoServices;

    public ProdutoController(ProdutoServices produtoServices) {
        this.produtoServices = produtoServices;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoServices.salvar(produto);
    }

    @GetMapping()
    public List<Produto> listarProdutos() {
        return produtoServices.listarProdutos();
    }
    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoServices.obterPorId(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable String id) {
        produtoServices.deletar(id);
    }

    @PutMapping("{id}")
    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto novoProduto) {
        return produtoServices.atualizar(id, novoProduto);
    }
}
