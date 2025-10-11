package first.project.java.api.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCompraDTO {
    private ProdutoDTO produto;
    private Integer quantidade; // Quantidade do produto na compra
    private Double subtotal; // Opcional: quantidade * valorProduto
}