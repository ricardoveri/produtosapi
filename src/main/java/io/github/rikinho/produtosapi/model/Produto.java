package io.github.rikinho.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private int quantidade;
    private Double preco;
    private LocalDate dataPostagem;

    @PrePersist
    public void gerarId() {
        if (this.id == null || this.id.trim().isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public void gerarDataPostagem() {
        if (this.dataPostagem == null) {
            this.dataPostagem = LocalDate.now();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostada) {
        this.dataPostagem = dataPostada;
    }

    @Override
    public String toString() {
        return "Produto{"
                + "id='" + id + '\''
                + ", nome='" + nome + '\''
                + ", descricao='" + descricao + '\''
                + ", quantidade='" + quantidade + '\''
                + ", preco='" + preco + '\''
                + ", data='" + dataPostagem + '\''
                + '}';
    }
}
