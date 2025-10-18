package first.project.java.api.Service;

import first.project.java.api.Dto.CompraDTO;
import first.project.java.api.Dto.CompraRequestDTO;
import first.project.java.api.Dto.ItemCompraDTO;
import first.project.java.api.Entity.Compra;
import first.project.java.api.Entity.ItemCompra;
import first.project.java.api.Entity.Produto;
import first.project.java.api.Entity.TipoPagamento;
import first.project.java.api.Mapper.CompraMapper;
import first.project.java.api.Repository.CompraRepository;
import first.project.java.api.Repository.ItemCompraRespository;
import first.project.java.api.Repository.ProdutoRepository;
import first.project.java.api.Repository.TipoPagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompraService {
    private final CompraRepository compraRepository;
    private final CompraMapper compraMapper;
    private final ItemCompraRespository itemCompraRepository;
    private final ProdutoRepository produtoRepository;
    private final TipoPagamentoRepository tipoPagamentoRepository;

    public CompraService(CompraRepository compraRepository
                        , CompraMapper compraMapper
                        , ItemCompraRespository itemCompraRespository
                        , ProdutoRepository produtoRepository
                        , TipoPagamentoRepository tipoPagamentoRepository){
        this.compraMapper = compraMapper;
        this.compraRepository = compraRepository;
        this.itemCompraRepository = itemCompraRespository;
        this.produtoRepository = produtoRepository;
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    public CompraDTO buscarDetalhesCompra(Long id){
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra com ID " + id + " não encontrada."));
        return compraMapper.toDTO(compra);
    }

    @Transactional
    public CompraDTO salvarNovaCompra(CompraRequestDTO request) {
        TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(request.getIdTipoPagamento())
                .orElseThrow(() -> new RuntimeException("Tipo de Pagamento não encontrado."));

        Compra novaCompra = new Compra();
        novaCompra.setNome(request.getNomeCliente());
        novaCompra.setDataCompra(new Date());
        novaCompra.setIdTipoPagamento(tipoPagamento);
        Compra compraSalva = compraRepository.save(novaCompra);
        for (ItemCompraDTO itemDto : request.getItens()) {
            Produto produto = produtoRepository.findById(itemDto.getIdProduto())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

            ItemCompra item = new ItemCompra();
            item.setCompra(compraSalva);
            item.setProduto(produto);
            itemCompraRepository.save(item);
        }
        return compraMapper.toDTO(compraSalva);
    }
}
