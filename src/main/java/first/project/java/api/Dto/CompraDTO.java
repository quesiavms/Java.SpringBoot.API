package first.project.java.api.Dto;

import first.project.java.api.Entity.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private Long idCompra; // Incluir o ID
    private String nome;
    private Date dataCompra;
    private List<ItemCompraDTO> itens;
    private TipoPagamento tipoPagamento;
}