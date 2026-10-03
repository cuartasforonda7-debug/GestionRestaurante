package app.backend.presentacion.controlador;
import app.aplicacion.servicios.ProductoService;
import dominio.entidades.Producto;

public class ProductoController {
    private ProductoService service;
    
    public ProductoController (ProductoService service) {
        this.service = service;
    }

    public void registrarProducto(Producto producto) {
        /*   try {
            service.registrarProducto(producto);
            System.out.println("Producto registrado correctamente!");
        } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Problema de la base de datos.");
        }
            */
    }
}
