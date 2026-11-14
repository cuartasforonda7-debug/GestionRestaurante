package dominio.puertos.entrada;

import dominio.entidades.Usuario;
import java.util.List;

/**
 * PUERTO DE ENTRADA (Inbound Port)
 * Define lo que el sistema PUEDE hacer con los Usuarios (Casos de Uso del negocio).
 */
public interface GestionarUsuarioPort {

    Usuario registrarUsuario(Usuario usuario);

    Usuario iniciarSesion(String email, String contrasenaPlana);

    Usuario buscarPorId(int idUsuario);

    List<Usuario> listarUsuarios();

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(int idUsuario);

    int totalUsuarios();
}

