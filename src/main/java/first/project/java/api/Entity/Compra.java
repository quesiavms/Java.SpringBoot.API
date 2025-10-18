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

    @ManyToOne
    @JoinColumn(name = "idTipoPagamento")
    private TipoPagamento idTipoPagamento;

    @Column(name = "DataCompra")
    private Date dataCompra;

    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itensCompra;
}
