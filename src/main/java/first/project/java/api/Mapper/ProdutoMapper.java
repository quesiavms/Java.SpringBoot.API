package first.project.java.api.Mapper;

import first.project.java.api.Dto.ProdutoDTO;
import first.project.java.api.Entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoDTO toDTO(Produto produto){
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(produto.getId());
        dto.setNomeProduto(produto.getNomeProduto());
        dto.setValorProduto(produto.getValorProduto());
        return dto;
    }

    public Produto toEntity(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setId(produto.getId());
        produto.setNomeProduto(dto.getNomeProduto());
        produto.setValorProduto(dto.getValorProduto());
        return produto;
    }
}
