package first.project.java.api.Mapper;

import first.project.java.api.Dto.CompraDTO;
import first.project.java.api.Entity.Compra;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class CompraMapper {
    private final ItemCompraMapper itemCompraMapper;

    public CompraMapper(ItemCompraMapper itemCompraMapper) {
        this.itemCompraMapper = itemCompraMapper;
    }

    public CompraDTO toDTO(Compra compra){
        CompraDTO dto = new CompraDTO();
        dto.setNome(compra.getNome());
        dto.setTipoPagamento(compra.getIdTipoPagamento());
        dto.setDataCompra(compra.getDataCompra());
        if (compra.getItensCompra() != null) {
            dto.setItens(itemCompraMapper.toDTO(compra.getItensCompra()));
        }
        return dto;
    }
}
