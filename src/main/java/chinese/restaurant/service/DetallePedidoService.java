package chinese.restaurant.service;

import chinese.restaurant.entity.DetallePedido;
import chinese.restaurant.entity.Pagos;
import chinese.restaurant.repository.DetallePedidoRepository;
import chinese.restaurant.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> getDetallePedido() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido getDetallePagoId(Integer id) {
        return detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de pedido encontrado"));
    }

    public String insertarDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
        return "Se registró el detalle pedido";
    }

}
