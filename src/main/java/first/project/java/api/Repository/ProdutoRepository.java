package first.project.java.api.Repository;

import first.project.java.api.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // gerenciando entidade Produto com IDs do tipo Long.
    // JpaRepository já tem métodos como .findAll(), .save(), .findById(Long id), etc.
}
