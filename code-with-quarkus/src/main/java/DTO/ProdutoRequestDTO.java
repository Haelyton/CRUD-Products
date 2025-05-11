package DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestDTO {

    private Long id;

    private String nome;

    private Double price;

    private Integer quantidadeEstoque;

    private String descricao;

    public ProdutoRequestDTO(final String descricao, final Long id, final String nome, final Double price, final Integer quantidadeEstoque) {
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.price = price;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public ProdutoRequestDTO() {
    }

}

