package chinese.restaurant.repository;

import chinese.restaurant.entity.Carta;
import chinese.restaurant.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {

    //List<Carta> findByNombreProductoLike(String nombre_producto);
   // List<Carta> findByDisponibleTrue();
}
