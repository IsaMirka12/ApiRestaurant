package chinese.restaurant.service;

import chinese.restaurant.entity.Carta;
import chinese.restaurant.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    public List<Carta> getCarta() {
        return cartaRepository.findAll();
    }

    public Carta getCartaId(Integer id) {
        return cartaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carta no encontrado"));
    }

    public String insertarCarta(Carta carta) {
        cartaRepository.save(carta);
        return "Se registró el plato";
    }

   /* @Transactional
    public void eliminarCartaLogico(Integer id) {
        Carta carta = cartaRepository.findById(id).orElseThrow(() -> new RuntimeException("Carta no encontrado"));

        carta.setDisponible(false);

        cartaRepository.save(carta);
    }



    public List<Carta> buscarPorNombreProducto(String nombre_producto) {
        List<Carta> cartas = cartaRepository.findByNombreProductoLike(nombre_producto);
        return cartas;
    }

    */

}
