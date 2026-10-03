package app.backend.infraestructura.adaptadores;
import app.backend.infraestructura.basedatos.ConexionBD;
import app.backend.infraestructura.excepciones.InfraestructuraException;
import dominio.entidades.Producto;
import dominio.puertos.salida.ProductoRepositoryPort;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {
    
        @Override 
        public void registrarProducto(Producto producto) {


        // CODIGO SQL!
        String sql = """
            INSERT INTO Productos
            (nombre, descripcion, unidadMedida, costo, precioVenta, stockActual, stockMinimo, estado)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        // TRY CON RECURSOS!
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql);
        ) {

            // STATEMENT.SETS PRODUCTO
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setString(3, producto.getUnidadMedida());
            statement.setDouble(4, producto.getCosto());
            statement.setDouble(5, producto.getPrecioVenta());
            statement.setDouble(6, producto.getStockActual());
            statement.setDouble(7, producto.getStockMinimo());
            statement.setBoolean(8, producto.isEstado());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al registrar el producto", e);
        }
    }

}
