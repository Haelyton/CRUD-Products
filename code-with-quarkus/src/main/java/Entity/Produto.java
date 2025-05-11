package Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "price_produto")
    private Double price;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

}
