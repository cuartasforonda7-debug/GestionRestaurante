package dominio.puertos.salida;

import dominio.entidades.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    void registrarUsuario(Usuario usuario);

    Optional<Usuario> buscarPorId(int idUsuario);

    Optional<Usuario> buscarPorEmail(String email);

    boolean existePorEmail(String email);

    List<Usuario> listarTodos();

    void actualizar(Usuario usuario);

    void eliminar(int idUsuario);

    /**
     * Devuelve el total de usuarios registrados en el sistema.
     * Buena práctica: Métrica de control e integridad (UserCounter).
     */
    int contarUsuarios();
}

