package first.project.java.api.Repository;

import first.project.java.api.Entity.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {
}
