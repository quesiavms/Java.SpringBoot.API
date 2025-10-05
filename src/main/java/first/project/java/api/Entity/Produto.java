package first.project.java.api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter // Cria todos os Getters
@Setter // Cria todos os Setters
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {
    @Id // indicador de chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indicador de ig auto generativo
    @Column(name = "idProduto")
    private Long id;

    @Column(name = "nomeProduto") // necessario mapear pq o JPA transcreve camelCase para snake_case
    private String nomeProduto;

    @Column(name = "valorProduto")
    private String valorProduto;
}
