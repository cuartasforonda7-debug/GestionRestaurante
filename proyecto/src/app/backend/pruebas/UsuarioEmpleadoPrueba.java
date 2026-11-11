package app.backend.pruebas;

import app.aplicacion.servicios.ControlAccesoService;
import app.aplicacion.servicios.EmpleadoService;
import app.aplicacion.servicios.UsuarioService;
import app.backend.configuracion.Config;
import dominio.entidades.Empleado;
import dominio.entidades.ModuloSistema;
import dominio.entidades.Rol;
import dominio.entidades.Usuario;
import dominio.excepciones.AccesoDenegadoException;
import dominio.excepciones.CredencialesInvalidasException;
import dominio.excepciones.UsuarioYaExisteException;
import dominio.puertos.salida.RolRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Clase interactiva de prueba para la Épica 1:
 * - Feature 1.1: HU-01 (Registrar usuario) y HU-02 (Iniciar sesión)
 * - Feature 1.2: HU-03 (Gestionar empleados y roles) y HU-04 (Control de permisos por rol)
 * 
 * Adaptada con las buenas prácticas del ejemplo de referencia (tikets_2_0):
 * - Menú interactivo por consola con Scanner.
 * - Validación y manejo limpio de excepciones.
 * - Conteo y métricas de registros (UserCounter/EmployeeCounter).
 */
public class UsuarioEmpleadoPrueba {

    private static Usuario usuarioSesionActual = null;

    public static void main(String[] args) {
        Config config = new Config();
        // Usamos los servicios en memoria para que se pueda probar de inmediato
        UsuarioService usuarioService = config.obtenerUsuarioServiceEnMemoria();
        EmpleadoService empleadoService = config.obtenerEmpleadoServiceEnMemoria();
        RolRepositoryPort rolRepository = config.obtenerRolRepositoryEnMemoria();
        ControlAccesoService accesoService = config.obtenerControlAccesoService();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        System.out.println("======================================================");
        System.out.println("  RESTAURANTE DE MAR — GESTION DE USUARIOS Y ROLES   ");
        System.out.println("======================================================");

        do {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(">> Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> registrarUsuarioHU01(scanner, usuarioService);
                case 2 -> iniciarSesionHU02(scanner, usuarioService);
                case 3 -> registrarEmpleadoHU03(scanner, empleadoService, rolRepository);
                case 4 -> consultarEmpleadosHU03(empleadoService);
                case 5 -> asignarRolEmpleadoHU03(scanner, empleadoService, rolRepository);
                case 6 -> probarControlPermisosHU04(scanner, accesoService);
                case 7 -> contarUsuariosYEmpleados(usuarioService, empleadoService);
                case 8 -> cerrarSesion();
                case 0 -> System.out.println("\n>> ¡Gracias por usar Restaurante de Mar! Saliendo...");
                default -> System.out.println(">> Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n------------------------------------------------------");
        if (usuarioSesionActual != null) {
            System.out.println(" Sesión activa: " + usuarioSesionActual.getNombre() 
                    + " [" + (usuarioSesionActual.getRol() != null ? usuarioSesionActual.getRol().getNombre() : "Sin Rol") + "]");
        } else {
            System.out.println(" Sesión activa: (Ninguna - Invitado)");
        }
        System.out.println("------------------------------------------------------");
        System.out.println("1. [HU-01] Registrar usuario");
        System.out.println("2. [HU-02] Iniciar sesión");
        System.out.println("3. [HU-03] Registrar empleado con rol");
        System.out.println("4. [HU-03] Consultar empleados");
        System.out.println("5. [HU-03] Asignar / Cambiar rol a empleado");
        System.out.println("6. [HU-04] Probar control de permisos según rol");
        System.out.println("7. [Métricas] Contar usuarios y empleados registrados");
        System.out.println("8. Cerrar sesión actual");
        System.out.println("0. Salir");
        System.out.println("------------------------------------------------------");
    }

    // ==========================================
    // HU-01: REGISTRAR USUARIO
    // ==========================================
    private static void registrarUsuarioHU01(Scanner sc, UsuarioService service) {
        System.out.println("\n--- [HU-01] REGISTRO DE NUEVO USUARIO ---");
        try {
            System.out.print("Nombre completo: ");
            String nombre = sc.nextLine();

            System.out.print("Correo electrónico: ");
            String email = sc.nextLine();

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();

            System.out.print("Contraseña (mínimo 6 caracteres): ");
            String password = sc.nextLine();

            Usuario nuevo = new Usuario();
            nuevo.setNombre(nombre);
            nuevo.setEmail(email);
            nuevo.setTelefono(telefono);
            nuevo.setContrasena(password);

            Usuario registrado = service.registrarUsuario(nuevo);
            System.out.println("\n>> [EXITO] Usuario registrado correctamente!");
            System.out.println("   ID Asignado: " + registrado.getIdUsuario());
            System.out.println("   Nombre: " + registrado.getNombre());
            System.out.println("   Email: " + registrado.getEmail());
            System.out.println("   Rol asignado: " + registrado.getRol().getNombre());
            System.out.println("   Hash de seguridad generado: " + registrado.getContrasena().substring(0, 15) + "...");
        } catch (UsuarioYaExisteException | IllegalArgumentException e) {
            System.out.println("\n>> [ERROR EN REGISTRO]: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n>> [ERROR INESPERADO]: " + e.getMessage());
        }
    }

    // ==========================================
    // HU-02: INICIAR SESIÓN
    // ==========================================
    private static void iniciarSesionHU02(Scanner sc, UsuarioService service) {
        System.out.println("\n--- [HU-02] INICIAR SESIÓN ---");
        try {
            System.out.print("Correo electrónico: ");
            String email = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            Usuario usuario = service.iniciarSesion(email, password);
            usuarioSesionActual = usuario;

            System.out.println("\n>> [EXITO] Autenticación exitosa!");
            System.out.println("   Bienvenido(a), " + usuario.getNombre());
            System.out.println("   Rol: " + (usuario.getRol() != null ? usuario.getRol().getNombre() : "Sin Rol asignado"));
        } catch (CredencialesInvalidasException | IllegalArgumentException e) {
            System.out.println("\n>> [ACCESO RECHAZADO]: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n>> [ERROR]: " + e.getMessage());
        }
    }

    // ==========================================
    // HU-03: REGISTRAR EMPLEADO CON ROL
    // ==========================================
    private static void registrarEmpleadoHU03(Scanner sc, EmpleadoService empService, RolRepositoryPort rolRepo) {
        System.out.println("\n--- [HU-03] REGISTRAR NUEVO EMPLEADO ---");
        try {
            System.out.print("Nombre del empleado: ");
            String nombre = sc.nextLine();

            System.out.print("Correo electrónico: ");
            String email = sc.nextLine();

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();

            System.out.println("\nRoles disponibles:");
            List<Rol> roles = rolRepo.listarTodos();
            for (Rol r : roles) {
                System.out.println("  [" + r.getIdRol() + "] " + r.getNombre() + " - " + r.getDescripcion());
            }
            System.out.print("Seleccione el ID del rol para el empleado: ");
            int idRol = Integer.parseInt(sc.nextLine().trim());

            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setEmail(email);
            nuevoEmpleado.setTelefono(telefono);
            nuevoEmpleado.setContrasena("Empleado2026*");
            nuevoEmpleado.setFechaIngreso(LocalDateTime.now());

            Empleado registrado = empService.registrarEmpleado(nuevoEmpleado, idRol);
            System.out.println("\n>> [EXITO] Empleado registrado correctamente!");
            System.out.println("   " + registrado);
        } catch (Exception e) {
            System.out.println("\n>> [ERROR AL REGISTRAR EMPLEADO]: " + e.getMessage());
        }
    }

    // ==========================================
    // HU-03: CONSULTAR EMPLEADOS
    // ==========================================
    private static void consultarEmpleadosHU03(EmpleadoService empService) {
        System.out.println("\n--- [HU-03] LISTADO GENERAL DE EMPLEADOS ---");
        List<Empleado> lista = empService.consultarEmpleados();
        if (lista.isEmpty()) {
            System.out.println(">> No hay empleados registrados actualmente.");
            return;
        }
        for (Empleado e : lista) {
            System.out.println(" - " + e);
        }
    }

    // ==========================================
    // HU-03: ASIGNAR / CAMBIAR ROL
    // ==========================================
    private static void asignarRolEmpleadoHU03(Scanner sc, EmpleadoService empService, RolRepositoryPort rolRepo) {
        System.out.println("\n--- [HU-03] ASIGNAR / MODIFICAR ROL A EMPLEADO ---");
        try {
            consultarEmpleadosHU03(empService);
            System.out.print("\nIngrese el ID del empleado a modificar: ");
            int idEmp = Integer.parseInt(sc.nextLine().trim());

            System.out.println("\nRoles disponibles:");
            for (Rol r : rolRepo.listarTodos()) {
                System.out.println("  [" + r.getIdRol() + "] " + r.getNombre());
            }
            System.out.print("Ingrese el ID del nuevo Rol: ");
            int nuevoIdRol = Integer.parseInt(sc.nextLine().trim());

            empService.asignarRol(idEmp, nuevoIdRol);
            Empleado actualizado = empService.buscarPorId(idEmp);
            System.out.println("\n>> [EXITO] Rol actualizado correctamente!");
            System.out.println("   " + actualizado);
        } catch (Exception e) {
            System.out.println("\n>> [ERROR]: " + e.getMessage());
        }
    }

    // ==========================================
    // HU-04: CONTROL DE PERMISOS SEGÚN EL ROL
    // ==========================================
    private static void probarControlPermisosHU04(Scanner sc, ControlAccesoService accesoService) {
        System.out.println("\n--- [HU-04] CONTROL Y VALIDACIÓN DE PERMISOS POR ROL ---");
        if (usuarioSesionActual == null) {
            System.out.println(">> [AVISO] Actualmente no ha iniciado sesión.");
            System.out.println("   Inicie sesión primero (opción 2) o use las cuentas predeterminadas:");
            System.out.println("   * admin@restaurantedemar.com (Pass: Admin123*) -> Rol Administrador");
            System.out.println("   * carlos.mesero@restaurantedemar.com (Pass: Mesero123*) -> Rol Mesero");
            return;
        }

        System.out.println("Usuario actual: " + usuarioSesionActual.getNombre() 
                + " | Rol: " + (usuarioSesionActual.getRol() != null ? usuarioSesionActual.getRol().getNombre() : "Sin Rol"));
        System.out.println("\nSeleccione el módulo al que desea intentar acceder:");
        ModuloSistema[] modulos = ModuloSistema.values();
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("  [" + (i + 1) + "] " + modulos[i].name() + " (" + modulos[i].getDescripcion() + ")");
        }
        System.out.print("Módulo número: ");

        try {
            int sel = Integer.parseInt(sc.nextLine().trim());
            if (sel < 1 || sel > modulos.length) {
                System.out.println(">> Módulo inválido.");
                return;
            }
            ModuloSistema moduloElegido = modulos[sel - 1];

            // Verificación formal de permisos
            accesoService.verificarAcceso(usuarioSesionActual, moduloElegido);
            System.out.println("\n>> [ACCESO CONCEDIDO] El usuario tiene los permisos requeridos para ingresar a: " 
                    + moduloElegido.name());
        } catch (AccesoDenegadoException e) {
            System.out.println("\n>> [BLOQUEO DE SEGURIDAD]");
            System.out.println("   " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n>> [ERROR]: " + e.getMessage());
        }
    }

    // ==========================================
    // MÉTRICAS / CONTADORES (BUENA PRÁCTICA tikets_2_0)
    // ==========================================
    private static void contarUsuariosYEmpleados(UsuarioService uService, EmpleadoService eService) {
        System.out.println("\n--- [MÉTRICAS DEL SISTEMA (UserCounter / EmployeeCounter)] ---");
        System.out.println("Total de usuarios registrados en el sistema: " + uService.totalUsuarios());
        System.out.println("Total de empleados en el restaurante:       " + eService.totalEmpleados());
    }

    private static void cerrarSesion() {
        if (usuarioSesionActual != null) {
            System.out.println("\n>> Sesión de " + usuarioSesionActual.getNombre() + " cerrada correctamente.");
            usuarioSesionActual = null;
        } else {
            System.out.println("\n>> No había ninguna sesión activa.");
        }
    }
}

