package dominio.puertos.salida;
import dominio.entidades.Pago;
import java.util.List;

public interface PagoRepositoryPort {
    void guardar(Pago pago);
    Pago buscarPorId(String id);
    List<Pago> listarTodos();


    default void registrarPago(Pago pago) {
        guardar(pago);
    }
}
