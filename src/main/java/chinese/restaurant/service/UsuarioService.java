package chinese.restaurant.service;

import chinese.restaurant.entity.Usuario;
import chinese.restaurant.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Guardar o actualizar un usuario
    public String guardarActualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Se registro/actualizo el usuario";
    }



    @Transactional
    public void eliminarLogico(Integer id) {
        // Buscar el producto por ID
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Marcar el producto como eliminado (estado = false)
        usuario.setEstado(false);

        // Guardar el producto con el nuevo estado
        usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombreLike(nombre);
        return usuarios;
    }

}
