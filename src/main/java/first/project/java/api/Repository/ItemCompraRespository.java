package first.project.java.api.Repository;

import first.project.java.api.Entity.Compra;
import first.project.java.api.Entity.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCompraRespository extends JpaRepository<ItemCompra, Long> {
    List<ItemCompra> findByCompra(Compra compra);
}
