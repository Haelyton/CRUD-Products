package Services;

import DTO.ProdutoRequestDTO;
import DTO.ProdutoResponseDTO;
import Entity.Produto;
import Repository.ProdutoRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Inject
    private ProdutoRepository repository;

    public ProdutoRequestDTO createProduct(ProdutoRequestDTO dto) {
        Produto produto = Produto.builder()
                .nome(dto.getNome())
                .price(dto.getPrice())
                .descricao(dto.getDescricao())
                .quantidadeEstoque(dto.getQuantidadeEstoque())
                .build();

        Produto salvo = repository.save(produto);

        return new ProdutoRequestDTO(salvo.getDescricao(), salvo.getId(), salvo.getNome(), salvo.getPrice(), salvo.getQuantidadeEstoque());
    }


    public ProdutoRequestDTO updateProduct(ProdutoRequestDTO dto) {
        Produto produto = Produto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .quantidadeEstoque(dto.getQuantidadeEstoque())
                .build();

        Produto update = repository.save(produto);

        return new ProdutoRequestDTO(update.getDescricao(), update.getId(), update.getNome(), update.getPrice(), update.getQuantidadeEstoque());
    }

    public ProdutoResponseDTO findById(Long id) {
        Produto produto = repository.findById(id)
                .orElse(null);

        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .quantidadeEstoque(produto.getQuantidadeEstoque())
                .price(produto.getPrice())
                .build();
    }

    public List<ProdutoResponseDTO> findAllById(Long id) {
        return repository.findAll().stream()
                .map(produto -> ProdutoResponseDTO.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .descricao(produto.getDescricao())
                        .price(produto.getPrice())
                        .quantidadeEstoque(produto.getQuantidadeEstoque())
                        .build())
                .collect(Collectors.toList());
    }
}
