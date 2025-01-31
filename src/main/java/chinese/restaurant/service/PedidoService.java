package chinese.restaurant.service;

import chinese.restaurant.entity.EstadoPedido;
import chinese.restaurant.entity.Pedidos;
import chinese.restaurant.entity.Usuario;
import chinese.restaurant.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService{
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedidos> getPedido() {
        return pedidoRepository.findAll();
    }

    public Pedidos getPedidoId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    // Guardar o actualizar un usuario
    public String guardarActualizar(Pedidos pedidos) {
        pedidoRepository.save(pedidos);
        return "Se registro el pedido";
    }

    @Transactional
    public void eliminarPedidoLogico(Integer id) {
        Pedidos pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstadoP(false);
        pedidoRepository.save(pedido);
    }



}
