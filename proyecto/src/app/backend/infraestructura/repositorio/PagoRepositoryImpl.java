package app.backend.infraestructura.repositorio;

import dominio.entidades.Pago;
import dominio.puertos.salida.PagoRepositoryPort;
import java.util.ArrayList;
import java.util.List;

public class PagoRepositoryImpl implements PagoRepositoryPort {

    private List<Pago> baseDatos = new ArrayList<>();

    @Override
    public void registrarPago(Pago pago) {
        baseDatos.add(pago);
        System.out.println("PAGO REGISTRADO: " + pago.getMonto() + " - " + pago.getMetodo());
    }
}
