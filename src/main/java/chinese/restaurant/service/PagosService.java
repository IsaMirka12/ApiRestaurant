package chinese.restaurant.service;

import chinese.restaurant.entity.Pagos;
import chinese.restaurant.entity.Usuario;
import chinese.restaurant.repository.PagoRepository;
import chinese.restaurant.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosService {

    @Autowired
    PagoRepository pagoRepository;

    public List<Pagos> getPago() {
        return pagoRepository.findAll();
    }

    public Pagos getPagoId(Integer id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public String insertarPago(Pagos pago) {
        pagoRepository.save(pago);
        return "Se registró el pago correctamente";
    }

}
