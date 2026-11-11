package app.aplicacion.servicios;

import dominio.entidades.Empleado;
import dominio.entidades.Rol;
import dominio.excepciones.EntidadNoEncontradaException;
import dominio.excepciones.UsuarioYaExisteException;
import dominio.puertos.salida.EmpleadoRepositoryPort;
import dominio.puertos.salida.RolRepositoryPort;
import dominio.puertos.salida.UsuarioRepositoryPort;
import dominio.seguridad.SeguridadUtil;

import java.time.LocalDateTime;
import java.util.List;

public class EmpleadoService {

    private final EmpleadoRepositoryPort empleadoRepository;
    private final UsuarioRepositoryPort usuarioRepository;
    private final RolRepositoryPort rolRepository;

    public EmpleadoService(EmpleadoRepositoryPort empleadoRepository,
                           UsuarioRepositoryPort usuarioRepository,
                           RolRepositoryPort rolRepository) {
        this.empleadoRepository = empleadoRepository;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    // ==========================================
    // HU-03: GESTIONAR EMPLEADOS — REGISTRAR
    // ==========================================
    public Empleado registrarEmpleado(Empleado empleado, int idRol) {
        if (empleado == null) {
            throw new IllegalArgumentException("Los datos del empleado no pueden ser nulos.");
        }
        if (empleado.getNombre() == null || empleado.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado es obligatorio.");
        }
        if (empleado.getEmail() == null || empleado.getEmail().isBlank()) {
            throw new IllegalArgumentException("El correo del empleado es obligatorio.");
        }

        // Evitar duplicados
        if (usuarioRepository.existePorEmail(empleado.getEmail())) {
            throw new UsuarioYaExisteException("Ya existe un usuario o empleado con el correo: " + empleado.getEmail());
        }

        // Asignar y validar rol
        Rol rol = rolRepository.buscarPorId(idRol)
                .orElseThrow(() -> new EntidadNoEncontradaException("El rol con ID " + idRol + " no existe."));
        empleado.setRol(rol);

        // Contraseña por defecto si no viene dada
        if (empleado.getContrasena() == null || empleado.getContrasena().isBlank()) {
            empleado.setContrasena("Empleado123*"); // Contraseña temporal
        }
        empleado.setContrasena(SeguridadUtil.hashearContrasena(empleado.getContrasena()));

        if (empleado.getFechaIngreso() == null) {
            empleado.setFechaIngreso(LocalDateTime.now());
        }
        if (empleado.getFechaRegistro() == null) {
            empleado.setFechaRegistro(LocalDateTime.now());
        }
        empleado.setEstado(true);

        empleadoRepository.registrarEmpleado(empleado);
        return empleado;
    }

    // ==========================================
    // HU-03: CONSULTAR EMPLEADOS
    // ==========================================
    public List<Empleado> consultarEmpleados() {
        return empleadoRepository.listarTodos();
    }

    public Empleado buscarPorId(int idEmpleado) {
        return empleadoRepository.buscarPorId(idEmpleado)
                .orElseThrow(() -> new EntidadNoEncontradaException("Empleado no encontrado con ID: " + idEmpleado));
    }

    public List<Empleado> listarPorRol(int idRol) {
        return empleadoRepository.listarPorRol(idRol);
    }

    // ==========================================
    // HU-03: ASIGNAR / CAMBIAR ROL
    // ==========================================
    public void asignarRol(int idEmpleado, int nuevoIdRol) {
        Empleado empleado = buscarPorId(idEmpleado);

        Rol nuevoRol = rolRepository.buscarPorId(nuevoIdRol)
                .orElseThrow(() -> new EntidadNoEncontradaException("No se encontró el rol con ID: " + nuevoIdRol));

        empleado.setRol(nuevoRol);
        empleadoRepository.actualizar(empleado);
    }

    public int totalEmpleados() {
        return empleadoRepository.contarEmpleados();
    }
}

