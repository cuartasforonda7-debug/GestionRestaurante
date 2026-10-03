package app.backend.pruebas;

import app.aplicacion.servicios.ProductoService;
import app.backend.configuracion.Config;
import dominio.entidades.Producto;

public class ProductoServicePrueba {

    public static void main(String[] args) {
        Config config = new Config();

        ProductoService service = config.obtenerProductoService();
        
        Producto newProducto = new Producto();
        newProducto.setNombre("Pescado");
        newProducto.setDescripcion("Filete de Trucha");
        newProducto.setUnidadMedida("kg");
        newProducto.setCosto(12000);
        newProducto.setStockActual(18);
        newProducto.setStockMinimo(5);
        
        try {
            System.out.println("Enviando Producto a el servicio para validación y registro...");
            service.registrarProducto(newProducto);
        } catch (Exception e) {
            System.out.println("Error en la ejecucion del flujo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
