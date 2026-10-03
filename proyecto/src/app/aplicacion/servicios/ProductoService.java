package app.aplicacion.servicios;
import dominio.entidades.Producto;
import dominio.puertos.salida.ProductoRepositoryPort;
public class ProductoService {

    private ProductoRepositoryPort repositoryPort;

    // INYECCION POR CONSTRUCTOR!
    public ProductoService(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

        // METODO REGISTRAR PRODUCTO
    public void registrarProducto(Producto producto) {
        validarProducto(producto);

        repositoryPort.registrarProducto(producto);
    }

    // METODO VALIDAR PRODUCTO!    
    private void validarProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio!");
        }

        if (producto.getUnidadMedida() == null || producto.getUnidadMedida().isBlank()) {
            throw new IllegalArgumentException("La unidad de medida es obligatoria!");
        }

        if (Double.isNaN(producto.getCosto()) || producto.getCosto() < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }

        if (producto.getStockActual() < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo!");
        }

        if (producto.getStockMinimo() < 0) {
            throw new IllegalArgumentException("El stock minimo no puede ser negativo");
        }

    }

}