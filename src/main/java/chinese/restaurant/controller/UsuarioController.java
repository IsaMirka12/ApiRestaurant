package chinese.restaurant.controller;

import chinese.restaurant.entity.Respuesta;
import chinese.restaurant.entity.Usuario;
import chinese.restaurant.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarios = usuarioService.getUsuario();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();  // Respuesta 204 si no hay usuarios
        }
        return ResponseEntity.ok(usuarios);  // Respuesta 200 con la lista de usuarios
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id) {
        try {
            Usuario usuario = usuarioService.getUsuarioId(id);
            return ResponseEntity.ok(usuario);  // Respuesta 200 si el usuario existe
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Respuesta 404 si no se encuentra el usuario
        }
    }

    // Crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<Respuesta> guardarActualizar(@RequestBody Usuario usuario) {
        Number idUsuario = usuarioService.guardarActualizar(usuario);
        Respuesta rep = new Respuesta("Se registro/actualizo correctamente", true, "ADMIN", idUsuario);
        return ResponseEntity.ok(rep);  // Respuesta 201 si el recurso fue creado/actualizado
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarLogico(@PathVariable Integer id) {
        try {
            usuarioService.eliminarLogico(id);  // Llamada al servicio para eliminar lógicamente
            Respuesta respuesta = new Respuesta("El usuario ha sido eliminado", true, 0);
            return ResponseEntity.ok(respuesta);  // Retornar el DTO con el mensaje de éxito
        } catch (RuntimeException e) {
            Respuesta respuesta = new Respuesta("Usuario no encontrado", false, 0);
            return ResponseEntity.status(404).body(respuesta);  // Retornar el DTO con el mensaje de error
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Usuario>> buscarPorNombre(@RequestParam String name) {
        List<Usuario> usuarios = usuarioService.buscarPorNombre(name);
        return ResponseEntity.ok(usuarios);
    }
}
