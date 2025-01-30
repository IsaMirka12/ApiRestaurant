package chinese.restaurant.service;

import chinese.restaurant.entity.Usuario;
import chinese.restaurant.repository.UsuarioRepository;
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
    public void guardarActualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
