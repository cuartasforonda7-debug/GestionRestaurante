package dominio.puertos.salida;
import dominio.entidades.Pago;

public interface PagoRepositoryPort {
    void registrarPago(Pago pago);
}
