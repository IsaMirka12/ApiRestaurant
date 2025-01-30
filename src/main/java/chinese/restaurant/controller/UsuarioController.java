package chinese.restaurant.controller;

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

    // Crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<Void> guardarActualizar(@RequestBody Usuario usuario) {
        usuarioService.guardarActualizar(usuario);
        return ResponseEntity.status(201).build();  // Respuesta 201 si el recurso fue creado/actualizado
    }

    // Eliminar un usuario por ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id") Integer id) {
        try {
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();  // Respuesta 204 si el recurso fue eliminado
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Respuesta 404 si no se encuentra el usuario
        }
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
}
