package first.project.java.api.Dto;
import first.project.java.api.Entity.TipoPagamento;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class CompraRequestDTO {
    private String nomeCliente;
    private Long idTipoPagamento;
    private List<ItemCompraDTO> itens;
}
