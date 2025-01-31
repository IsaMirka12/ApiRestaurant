package chinese.restaurant.repository;

import chinese.restaurant.entity.EstadoPedido;
import chinese.restaurant.entity.Pedidos;
import chinese.restaurant.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer  > {

    List<Pedidos> findByEstado(EstadoPedido estado);
    List<Pedidos> findByEstadoPTrue();

}
