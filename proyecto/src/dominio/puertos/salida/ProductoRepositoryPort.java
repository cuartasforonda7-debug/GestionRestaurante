package dominio.puertos.salida;
import dominio.entidades.Producto;


public interface ProductoRepositoryPort {
    
        void registrarProducto (Producto producto);
    
}