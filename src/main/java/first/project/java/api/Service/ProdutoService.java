package first.project.java.api.Service;

import first.project.java.api.Dto.ProdutoDTO;
import first.project.java.api.Entity.Produto;
import first.project.java.api.Mapper.ProdutoMapper;
import first.project.java.api.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // essencial para que o Spring gerencie
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper){
        this.produtoRepository = produtoRepository; //metodo construtor
        this.produtoMapper = produtoMapper;
    }

    public ProdutoDTO salvar(ProdutoDTO dto){
        Produto produto = produtoMapper.toEntity(dto);
        Produto savedProduto = produtoRepository.save(produto);
        return produtoMapper.toDTO(savedProduto);
    }

    public List<ProdutoDTO> listarProdutos(){
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper :: toDTO)
                .collect(Collectors.toList());
    }

    public void atualizarProduto (Long id, ProdutoDTO dto){
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if(produtoOpt.isPresent()){
            Produto produto = produtoOpt.get();
            produto.setNomeProduto(dto.getNomeProduto());
            produto.setValorProduto(dto.getValorProduto());
            produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    public void deletarProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
        produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }
}
