package chinese.restaurant.controller;

import chinese.restaurant.entity.Carta;
import chinese.restaurant.entity.Respuesta;
import chinese.restaurant.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/carta")
public class CartaController {

    @Autowired
    CartaService cartaService;

    @GetMapping
    public ResponseEntity<List<Carta>> getAll() {
        List<Carta> cartas = cartaService.getCarta();
        if (cartas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cartas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carta> getById(@PathVariable("id") Integer id) {
        try {
            Carta carta = cartaService.getCartaId(id);
            return ResponseEntity.ok(carta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Respuesta> insertarCarta(@RequestBody Carta carta) {
        String respuesta = cartaService.insertarCarta(carta);
        Respuesta rep = new Respuesta(respuesta, true);
        return ResponseEntity.ok(rep);
    }

    /*
    @PutMapping("/eliminar/{id}")

    public ResponseEntity<Respuesta> eliminarLogico(@PathVariable Integer id) {
        try {
            cartaService.eliminarCartaLogico(id);
            Respuesta respuesta = new Respuesta("El plato ha sido eliminado", true);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            Respuesta respuesta = new Respuesta("Plato no encontrado", false);
            return ResponseEntity.status(404).body(respuesta);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Carta>> buscarPorNombreProducto(@RequestParam String nombre_producto) {
        List<Carta> cartas = cartaService.buscarPorNombreProducto("%"+nombre_producto+"%");
        return ResponseEntity.ok(cartas);
    }


     */
}
