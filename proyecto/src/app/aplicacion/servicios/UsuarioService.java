package app.aplicacion.servicios;

import dominio.entidades.Rol;
import dominio.entidades.Usuario;
import dominio.excepciones.CredencialesInvalidasException;
import dominio.excepciones.EntidadNoEncontradaException;
import dominio.excepciones.UsuarioYaExisteException;
import dominio.puertos.entrada.GestionarUsuarioPort;
import dominio.puertos.salida.RolRepositoryPort;
import dominio.puertos.salida.UsuarioRepositoryPort;
import dominio.seguridad.SeguridadUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public class UsuarioService implements GestionarUsuarioPort {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final int LONGITUD_MINIMA_PASSWORD = 6;

    private final UsuarioRepositoryPort usuarioRepository;
    private final RolRepositoryPort rolRepository;

    public UsuarioService(UsuarioRepositoryPort usuarioRepository, RolRepositoryPort rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    // ==========================================
    // HU-01: REGISTRAR USUARIO
    // ==========================================
    public Usuario registrarUsuario(Usuario usuario) {
        validarDatosUsuario(usuario);

        // Evitar duplicados por email
        if (usuarioRepository.existePorEmail(usuario.getEmail())) {
            throw new UsuarioYaExisteException("Ya existe un usuario registrado con el correo: " + usuario.getEmail());
        }

        // Asignar rol por defecto (Cliente) si no tiene uno
        if (usuario.getRol() == null) {
            Rol rolDefault = rolRepository.buscarPorNombre(Rol.ROL_CLIENTE)
                    .orElse(new Rol(6, Rol.ROL_CLIENTE, "Cliente general del restaurante"));
            usuario.setRol(rolDefault);
        }

        // Seguridad: Hashear contraseña antes de almacenar
        String passwordHasheada = SeguridadUtil.hashearContrasena(usuario.getContrasena());
        usuario.setContrasena(passwordHasheada);

        // Metadatos
        usuario.setEstado(true);
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }

        usuarioRepository.registrarUsuario(usuario);
        return usuario;
    }

    // ==========================================
    // HU-02: INICIAR SESIÓN (AUTENTICACIÓN)
    // ==========================================
    public Usuario iniciarSesion(String email, String contrasenaPlana) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El correo electrónico es requerido.");
        }
        if (contrasenaPlana == null || contrasenaPlana.isBlank()) {
            throw new IllegalArgumentException("La contraseña es requerida.");
        }

        Usuario usuario = usuarioRepository.buscarPorEmail(email.trim().toLowerCase())
                .orElseThrow(() -> new CredencialesInvalidasException("Credenciales incorrectas: Correo o contraseña no válidos."));

        if (!usuario.isEstado()) {
            throw new CredencialesInvalidasException("La cuenta del usuario se encuentra inactiva. Comuníquese con el administrador.");
        }

        boolean coincide = SeguridadUtil.verificarContrasena(contrasenaPlana, usuario.getContrasena());
        if (!coincide) {
            throw new CredencialesInvalidasException("Credenciales incorrectas: Correo o contraseña no válidos.");
        }

        return usuario;
    }

    // ==========================================
    // MÉTODOS DE CONSULTA Y GESTIÓN
    // ==========================================
    public Usuario buscarPorId(int idUsuario) {
        return usuarioRepository.buscarPorId(idUsuario)
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado con ID: " + idUsuario));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarTodos();
    }

    public void actualizarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("El ID del usuario a actualizar es inválido.");
        }
        validarCamposBasicos(usuario.getNombre(), usuario.getEmail());
        usuarioRepository.actualizar(usuario);
    }

    public void eliminarUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario debe ser mayor a 0.");
        }
        usuarioRepository.eliminar(idUsuario);
    }

    public int totalUsuarios() {
        return usuarioRepository.contarUsuarios();
    }

    // ==========================================
    // VALIDACIONES INTERNAS
    // ==========================================
    private void validarDatosUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        validarCamposBasicos(usuario.getNombre(), usuario.getEmail());

        if (usuario.getContrasena() == null || usuario.getContrasena().length() < LONGITUD_MINIMA_PASSWORD) {
            throw new IllegalArgumentException("La contraseña debe tener al menos " + LONGITUD_MINIMA_PASSWORD + " caracteres.");
        }
    }

    private void validarCamposBasicos(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio.");
        }
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido.");
        }
    }
}

