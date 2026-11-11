package app.aplicacion.servicios;

import dominio.entidades.ModuloSistema;
import dominio.entidades.Rol;
import dominio.entidades.Usuario;
import dominio.excepciones.AccesoDenegadoException;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Servicio encargado de la autorización y control de permisos (HU-04).
 * Asocia a cada rol los módulos del restaurante a los que tiene acceso permitido.
 */
public class ControlAccesoService {

    private final Map<String, Set<ModuloSistema>> permisosPorRol;

    public ControlAccesoService() {
        this.permisosPorRol = new HashMap<>();
        configurarPermisosPorDefecto();
    }

    private void configurarPermisosPorDefecto() {
        // 1. ADMINISTRADOR: Acceso absoluto a todos los módulos
        permisosPorRol.put(
                Rol.ROL_ADMINISTRADOR.toLowerCase(),
                EnumSet.allOf(ModuloSistema.class)
        );

        // 2. CAJERO: Ventas, Pagos, Pedidos, Menús y Consulta de Productos
        permisosPorRol.put(
                Rol.ROL_CAJERO.toLowerCase(),
                EnumSet.of(
                        ModuloSistema.GESTION_VENTAS_Y_PAGOS,
                        ModuloSistema.GESTION_PEDIDOS,
                        ModuloSistema.GESTION_MENUS,
                        ModuloSistema.GESTION_PRODUCTOS_E_INVENTARIO
                )
        );

        // 3. MESERO: Creación y gestión de pedidos, visualización de menús y productos
        permisosPorRol.put(
                Rol.ROL_MESERO.toLowerCase(),
                EnumSet.of(
                        ModuloSistema.GESTION_PEDIDOS,
                        ModuloSistema.GESTION_MENUS,
                        ModuloSistema.GESTION_PRODUCTOS_E_INVENTARIO
                )
        );

        // 4. COCINERO: Consulta y cambio de estado de pedidos en preparación y productos
        permisosPorRol.put(
                Rol.ROL_COCINERO.toLowerCase(),
                EnumSet.of(
                        ModuloSistema.GESTION_PEDIDOS,
                        ModuloSistema.GESTION_PRODUCTOS_E_INVENTARIO
                )
        );

        // 5. DOMICILIARIO: Módulo de domicilios y consulta de pedidos asignados
        permisosPorRol.put(
                Rol.ROL_DOMICILIARIO.toLowerCase(),
                EnumSet.of(
                        ModuloSistema.GESTION_DOMICILIOS,
                        ModuloSistema.GESTION_PEDIDOS
                )
        );

        // 6. CLIENTE: Consulta de menús y pedidos propios
        permisosPorRol.put(
                Rol.ROL_CLIENTE.toLowerCase(),
                EnumSet.of(
                        ModuloSistema.GESTION_MENUS,
                        ModuloSistema.GESTION_PEDIDOS
                )
        );
    }

    /**
     * Valida si un usuario tiene acceso permitido a un determinado módulo.
     */
    public boolean tienePermiso(Usuario usuario, ModuloSistema modulo) {
        if (usuario == null || usuario.getRol() == null) {
            return false;
        }

        String rolNombre = usuario.getRol().getNombre();
        if (rolNombre == null) {
            return false;
        }

        Set<ModuloSistema> permitidos = permisosPorRol.getOrDefault(rolNombre.toLowerCase(), Collections.emptySet());
        return permitidos.contains(modulo);
    }

    /**
     * Exige que el usuario tenga acceso al módulo; si no, arroja AccesoDenegadoException.
     */
    public void verificarAcceso(Usuario usuario, ModuloSistema modulo) {
        if (usuario == null) {
            throw new AccesoDenegadoException("Acceso denegado: No se ha autenticado ningún usuario en el sistema.");
        }
        if (usuario.getRol() == null) {
            throw new AccesoDenegadoException("Acceso denegado: El usuario '" + usuario.getNombre() + "' no cuenta con un rol asignado.");
        }

        if (!tienePermiso(usuario, modulo)) {
            throw new AccesoDenegadoException(
                    "Acceso denegado: El usuario '" + usuario.getNombre() + "' con rol [" 
                    + usuario.getRol().getNombre() + "] no tiene permisos para acceder a: " 
                    + modulo.getDescripcion()
            );
        }
    }

    /**
     * Devuelve el conjunto de módulos accesibles para un rol.
     */
    public Set<ModuloSistema> obtenerPermisosDeRol(String nombreRol) {
        if (nombreRol == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(permisosPorRol.getOrDefault(nombreRol.toLowerCase(), Collections.emptySet()));
    }
}

