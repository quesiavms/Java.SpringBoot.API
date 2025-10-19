package first.project.java.api.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // nao inclui campo no json de resposta se esta for nula
public class ItemCompraDTO {
    private Long idProduto;
    private ProdutoDTO produto;
}