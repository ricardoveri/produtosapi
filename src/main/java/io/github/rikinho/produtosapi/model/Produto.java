package io.github.rikinho.produtosapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    private UUID id = UUID.randomUUID();
    private String nome;
    private String descricao;
    private int quantidade;
    private Double preco;
    private LocalDate dataPostagem;

    public void gerarDataPostagem() {
        if (this.dataPostagem == null) {
            this.dataPostagem = LocalDate.now();
        }
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
