package app.backend.configuracion;
import app.aplicacion.servicios.ProductoService;
import app.backend.infraestructura.adaptadores.ProductoRepositoryAdapter;



public class Config {

    public ProductoService obtenerProductoService () {
        
        ProductoRepositoryAdapter adapter = new ProductoRepositoryAdapter();

        ProductoService service = new ProductoService(adapter);

        return service;
    }     
}