package chinese.restaurant.controller;


import chinese.restaurant.entity.Respuesta;
import chinese.restaurant.entity.Pedidos;
import chinese.restaurant.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController {

    @Autowired
    private  PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedidos>> getAll() {
        List<Pedidos> pedidos = pedidoService.getPedido();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();  // Respuesta 204 si no hay usuarios
        }
        return ResponseEntity.ok(pedidos);  // Respuesta 200 con la lista de usuarios
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> getById(@PathVariable("id") Integer id) {
        try {
            Pedidos pedido = pedidoService.getPedidoId(id);
            return ResponseEntity.ok(pedido);  // Respuesta 200 si el usuario existe
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Respuesta 404 si no se encuentra el usuario
        }
    }

    @PostMapping
    public ResponseEntity<Respuesta> guardarActualizar(@RequestBody Pedidos pedidos) {
        String respuesta = pedidoService.guardarActualizar(pedidos);
        Respuesta rep = new Respuesta(respuesta, true);
        return ResponseEntity.ok(rep);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarPedidoLogico(@PathVariable Integer id) {
        try {
            pedidoService.eliminarPedidoLogico(id);
            Respuesta respuesta = new Respuesta("El pedido ha sido eliminado", true);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            Respuesta respuesta = new Respuesta("Pedido no encontrado", false);
            return ResponseEntity.status(404).body(respuesta);
        }
    }


}
