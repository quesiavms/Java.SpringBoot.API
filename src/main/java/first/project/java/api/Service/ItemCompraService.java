package first.project.java.api.Service;

import first.project.java.api.Dto.ItemCompraDTO;
import first.project.java.api.Entity.Compra;
import first.project.java.api.Entity.ItemCompra;
import first.project.java.api.Mapper.ItemCompraMapper;
import first.project.java.api.Repository.ItemCompraRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCompraService {
    private final ItemCompraRespository itemCompraRespository;
    private final ItemCompraMapper itemCompraMapper;

    public ItemCompraService(ItemCompraRespository itemCompraRespository, ItemCompraMapper itemCompraMapper){
        this.itemCompraRespository = itemCompraRespository;
        this.itemCompraMapper = itemCompraMapper;
    }

    public List<ItemCompraDTO> buscarItensPorCompra(Compra compra){
        List<ItemCompra> itens = itemCompraRespository.findByCompra(compra);
        return itemCompraMapper.toDTO(itens);
    }
}
