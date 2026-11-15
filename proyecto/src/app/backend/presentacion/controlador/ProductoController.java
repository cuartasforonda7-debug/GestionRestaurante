package app.backend.presentacion.controlador;

import dominio.entidades.Producto;
import dominio.puertos.entrada.GestionarProductoPort;

public class ProductoController {

    private final GestionarProductoPort service;
    
    public ProductoController(GestionarProductoPort service) {
        this.service = service;
    }

    public void registrarProducto(Producto producto) {
        try {
            service.registrarProducto(producto);
            System.out.println(">> Producto registrado correctamente!");
        } catch (IllegalArgumentException e) {
            System.err.println(">> Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(">> Problema al registrar el producto: " + e.getMessage());
        }
    }
}
