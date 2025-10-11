package first.project.java.api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCompra")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCompra> itens;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Long idTipoPagamento;

    @Column(name = "DataCompra")
    private Date dataCompra;
}
