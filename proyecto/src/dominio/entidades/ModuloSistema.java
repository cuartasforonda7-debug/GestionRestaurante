package dominio.entidades;

/**
 * Módulos del sistema sobre los cuales se controla el acceso y los permisos por rol.
 */
public enum ModuloSistema {
    GESTION_USUARIOS_Y_ROLES("Administración de usuarios, empleados y asignación de roles"),
    GESTION_PRODUCTOS_E_INVENTARIO("Control de productos, stock, costos y recetas"),
    GESTION_MENUS("Configuración de menús y opciones disponibles"),
    GESTION_PEDIDOS("Creación y seguimiento del estado de pedidos en sala y cocina"),
    GESTION_VENTAS_Y_PAGOS("Facturación, registro de cobros y confirmación de pagos"),
    GESTION_DOMICILIOS("Asignación de domiciliarios y liquidación de entregas"),
    REPORTES_FINANCIEROS("Visualización de métricas, ventas globales y auditoría");

    private final String descripcion;

    ModuloSistema(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

