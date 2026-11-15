package app.backend.infraestructura.adaptadores.memoria;

import dominio.entidades.Rol;
import dominio.entidades.Usuario;
import dominio.puertos.salida.UsuarioRepositoryPort;
import dominio.seguridad.SeguridadUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Adaptador de repositorio en memoria para Usuarios.
 * Inspirado en el patrón de lista de UserRepositoryImpl pero adaptado a la arquitectura hexagonal.
 */
public class InMemoryUsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final List<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    public InMemoryUsuarioRepositoryAdapter() {
        precargarDatosPrueba();
    }

    private void precargarDatosPrueba() {
        // Usuario Administrador inicial para pruebas
        Rol rolAdmin = new Rol(1, Rol.ROL_ADMINISTRADOR, "Administrador del sistema");
        Usuario admin = new Usuario(
                contadorId++,
                "Administrador Principal",
                "admin@restaurantedemar.com",
                "3001234567",
                SeguridadUtil.hashearContrasena("Admin123*"),
                true,
                LocalDateTime.now(),
                rolAdmin
        );
        usuarios.add(admin);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() == 0) {
            usuario.setIdUsuario(contadorId++);
        }
        usuarios.add(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(int idUsuario) {
        return usuarios.stream()
                .filter(u -> u.getIdUsuario() == idUsuario)
                .findFirst();
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        if (email == null) return Optional.empty();
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email.trim()))
                .findFirst();
    }

    @Override
    public boolean existePorEmail(String email) {
        if (email == null) return false;
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email.trim()));
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void actualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == usuario.getIdUsuario()) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    @Override
    public void eliminar(int idUsuario) {
        usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);
    }

    @Override
    public int contarUsuarios() {
        return usuarios.size();
    }
}

