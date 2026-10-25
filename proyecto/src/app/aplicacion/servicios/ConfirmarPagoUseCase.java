package app.aplicacion.servicios;

import app.backend.infraestructura.repositorio.PagoRepositoryImpl;
import dominio.entidades.Pago;

public class ConfirmarPagoUseCase {
    private final PagoRepositoryImpl repositorio;

    public ConfirmarPagoUseCase(PagoRepositoryImpl repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(String idPago, boolean aprobar) {
        Pago pago = repositorio.buscarPorId(idPago);
        if (pago == null) {
            throw new RuntimeException("Pago no encontrado: " + idPago);
        }
        if (aprobar) {
            pago.setEstado("CONFIRMADO");
        } else {
            pago.setEstado("RECHAZADO");
        }
        repositorio.guardar(pago);
    }
}
