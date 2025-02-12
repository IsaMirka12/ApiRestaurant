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
    public Number guardarActualizar(Pedidos pedidos) {
        Pedidos pedidoGuardado = pedidoRepository.save(pedidos);
        return pedidoGuardado.getId();
    }

    @Transactional
    public void eliminarPedidoLogico(Integer id) {
        Pedidos pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstadoP(false);
        pedidoRepository.save(pedido);
    }

    public void guardarPedido(Pedidos pedido) {
        pedidoRepository.save(pedido);  // Guarda o actualiza el pedido
    }

    public Pedidos obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id).orElse(null); // Retorna null si no lo encuentra
    }



}
