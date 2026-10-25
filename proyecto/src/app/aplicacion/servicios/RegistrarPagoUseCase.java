package app.aplicacion.servicios;

import dominio.entidades.Pago;
import dominio.puertos.salida.PagoRepositoryPort;
import java.time.LocalDateTime;

public class RegistrarPagoUseCase {

    private final PagoRepositoryPort pagoRepository;

    public RegistrarPagoUseCase(PagoRepositoryPort pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public void ejecutar(double monto, String metodo, String comprobante) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto debe ser > 0");
        }
        Pago pago = new Pago();
        pago.setFecha(LocalDateTime.now());
        pago.setMonto(monto);
        pago.setMetodo(metodo);
        pago.setEstado("PAGADO");
        pago.setComprobante(comprobante);

        pagoRepository.registrarPago(pago);
    }
}