package Services;

import DTO.ProdutoRequestDTO;
import DTO.ProdutoResponseDTO;
import Entity.Produto;
import Repository.ProdutoRepository;
import jakarta.enterprise.inject.IllegalProductException;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Inject
    private ProdutoRepository repository;

    public ProdutoResponseDTO createProduct(ProdutoRequestDTO dto) {
        Produto produto = Produto.builder()
                .nome(dto.getNome())
                .price(dto.getPrice())
                .descricao(dto.getDescricao())
                .quantidadeEstoque(dto.getQuantidadeEstoque())
                .build();

        Produto salvo = repository.save(produto);

        return new ProdutoResponseDTO(salvo.getDescricao(), salvo.getId(), salvo.getNome(), salvo.getPrice(), salvo.getQuantidadeEstoque());
    }


    public ProdutoResponseDTO updateProduct(ProdutoRequestDTO dto) {
        Produto produto = repository.findById(dto.getId())
                .orElse(null);

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPrice(dto.getPrice());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        Produto update = repository.save(produto);

        ProdutoResponseDTO produtoResponseDTO = ProdutoResponseDTO.builder()
                .id(update.getId())
                .nome(update.getNome())
                .descricao(update.getDescricao())
                .quantidadeEstoque(update.getQuantidadeEstoque())
                .price(update.getPrice())
                .build();

        return produtoResponseDTO;
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

    public List<ProdutoResponseDTO> findAll() {
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

    public void deleteProduct(Long id) {
        Produto produto = repository.findById(id).orElse(null);

        repository.delete(produto);
    }
}
