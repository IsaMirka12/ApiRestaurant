package chinese.restaurant.controller;

import chinese.restaurant.entity.DetallePedido;
import chinese.restaurant.entity.Pagos;
import chinese.restaurant.entity.Respuesta;
import chinese.restaurant.service.DetallePedidoService;
import chinese.restaurant.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/detallePedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> getAll() {
        List<DetallePedido> detallePedidos = detallePedidoService.getDetallePedido();
        if (detallePedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detallePedidos);  // Respuesta 200 con la lista de usuarios
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getById(@PathVariable("id") Integer id) {
        try {
            DetallePedido detallePedido = detallePedidoService.getDetallePagoId(id);
            return ResponseEntity.ok(detallePedido);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Respuesta> insertardetallePedido(@RequestBody DetallePedido detallePedido) {
        String respuesta = detallePedidoService.insertarDetallePedido(detallePedido);
        Respuesta rep = new Respuesta(respuesta, true);
        return ResponseEntity.ok(rep);
    }

}
