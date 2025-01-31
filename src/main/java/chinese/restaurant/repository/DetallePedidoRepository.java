package chinese.restaurant.repository;

import chinese.restaurant.entity.DetallePedido;
import chinese.restaurant.entity.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

}
