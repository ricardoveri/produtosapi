package io.github.rikinho.produtosapi.repository;

import io.github.rikinho.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
}
