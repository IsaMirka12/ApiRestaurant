package chinese.restaurant.controller;

import chinese.restaurant.entity.Pagos;
import chinese.restaurant.entity.Respuesta;
import chinese.restaurant.entity.Usuario;
import chinese.restaurant.service.PagosService;
import chinese.restaurant.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pago")
public class PagoController {

    @Autowired
    private PagosService pagosService;

    @GetMapping
    public ResponseEntity<List<Pagos>> getAll() {
        List<Pagos> pago = pagosService.getPago();
        if (pago.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pago);  // Respuesta 200 con la lista de usuarios
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagos> getById(@PathVariable("id") Integer id) {
        try {
            Pagos pago = pagosService.getPagoId(id);
            return ResponseEntity.ok(pago);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Respuesta> insertarPago(@RequestBody Pagos pagos) {
        String respuesta = pagosService.insertarPago(pagos);
        Respuesta rep = new Respuesta(respuesta, true);
        return ResponseEntity.ok(rep);
    }

}
