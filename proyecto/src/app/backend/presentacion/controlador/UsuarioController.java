package app.backend.presentacion.controlador;

import dominio.entidades.Empleado;
import dominio.entidades.Usuario;
import dominio.excepciones.CredencialesInvalidasException;
import dominio.excepciones.UsuarioYaExisteException;
import dominio.puertos.entrada.GestionarEmpleadoPort;
import dominio.puertos.entrada.GestionarUsuarioPort;

import java.util.List;

/**
 * CONTROLADOR (Capa de Presentación) para Usuarios y Empleados.
 * 
 * ¿Qué función cumple?
 * Es la puerta de entrada de las peticiones del usuario (desde la consola, web o API REST).
 * Recibe los datos, invoca el PUERTO DE ENTRADA (los casos de uso) y captura las excepciones
 * para presentar respuestas amigables al cliente o a la vista.
 */
public class UsuarioController {

    private final GestionarUsuarioPort gestionarUsuarioPort;
    private final GestionarEmpleadoPort gestionarEmpleadoPort;

    // INYECCIÓN DE DEPENDENCIAS POR CONSTRUCTOR
    public UsuarioController(GestionarUsuarioPort gestionarUsuarioPort, GestionarEmpleadoPort gestionarEmpleadoPort) {
        this.gestionarUsuarioPort = gestionarUsuarioPort;
        this.gestionarEmpleadoPort = gestionarEmpleadoPort;
    }

    // HU-01: REGISTRAR USUARIO
    public boolean registrarUsuario(Usuario usuario) {
        try {
            Usuario registrado = gestionarUsuarioPort.registrarUsuario(usuario);
            System.out.println(">> [201 CREADO] Usuario registrado con éxito: " + registrado.getNombre() + " (ID: " + registrado.getIdUsuario() + ")");
            return true;
        } catch (UsuarioYaExisteException e) {
            System.err.println(">> [409 CONFLICTO] Error: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println(">> [400 DATOS INVALIDOS] Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [500 ERROR INTERNO]: " + e.getMessage());
            return false;
        }
    }

    // HU-02: INICIAR SESIÓN
    public Usuario iniciarSesion(String email, String password) {
        try {
            Usuario logueado = gestionarUsuarioPort.iniciarSesion(email, password);
            System.out.println(">> [200 OK] Bienvenido(a) al Restaurante de Mar: " + logueado.getNombre());
            return logueado;
        } catch (CredencialesInvalidasException e) {
            System.err.println(">> [401 NO AUTORIZADO] Error de autenticación: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println(">> [500 ERROR INTERNO]: " + e.getMessage());
            return null;
        }
    }

    // HU-03: REGISTRAR EMPLEADO
    public boolean registrarEmpleado(Empleado empleado, int idRol) {
        try {
            Empleado nuevo = gestionarEmpleadoPort.registrarEmpleado(empleado, idRol);
            System.out.println(">> [201 CREADO] Empleado contratado exitosamente: " + nuevo.getNombre() + " con Rol: " + nuevo.getRol().getNombre());
            return true;
        } catch (Exception e) {
            System.err.println(">> [ERROR]: " + e.getMessage());
            return false;
        }
    }

    // HU-03: LISTAR EMPLEADOS
    public List<Empleado> obtenerTodosLosEmpleados() {
        return gestionarEmpleadoPort.consultarEmpleados();
    }

    // HU-03: REASIGNAR ROL
    public boolean cambiarRolEmpleado(int idEmpleado, int nuevoIdRol) {
        try {
            gestionarEmpleadoPort.asignarRol(idEmpleado, nuevoIdRol);
            System.out.println(">> [200 OK] Rol de empleado actualizado correctamente.");
            return true;
        } catch (Exception e) {
            System.err.println(">> [ERROR AL ACTUALIZAR ROL]: " + e.getMessage());
            return false;
        }
    }
}
