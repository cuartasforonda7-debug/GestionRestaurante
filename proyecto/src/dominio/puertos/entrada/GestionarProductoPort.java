package dominio.puertos.entrada;

import dominio.entidades.Producto;

/**
 * PUERTO DE ENTRADA (Inbound Port)
 * Define lo que el sistema PUEDE hacer con los Productos.
 */
public interface GestionarProductoPort {

    void registrarProducto(Producto producto);
}

