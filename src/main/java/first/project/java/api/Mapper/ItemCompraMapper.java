package first.project.java.api.Mapper;

import first.project.java.api.Dto.ItemCompraDTO;
import first.project.java.api.Entity.ItemCompra;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemCompraMapper {

    private final ProdutoMapper produtoMapper;

    public ItemCompraMapper(ProdutoMapper produtoMapper) {
        this.produtoMapper = produtoMapper;
    }

    public ItemCompraDTO toDTO(ItemCompra itemCompra){
        ItemCompraDTO dto = new ItemCompraDTO();
        dto.setProduto(produtoMapper.toDTO(itemCompra.getProduto()));
        return  dto;
    }

    public List<ItemCompraDTO> toDTO(List<ItemCompra> itens) {
        return itens.stream()
                .map(item -> this.toDTO(item))
                .collect(Collectors.toList());
    }
}
