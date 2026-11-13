package app.backend.infraestructura.repositorio;

import dominio.entidades.Pago;
import dominio.puertos.salida.PagoRepositoryPort;
import java.util.ArrayList;
import java.util.List;

public class PagoRepositoryImpl implements PagoRepositoryPort {

    private List<Pago> baseDatos = new ArrayList<>();
    private static int contador = 1;

    @Override
    public void guardar(Pago pago) {

        if (pago.getIdPago() == 0) {
            pago.setIdPago(contador++);
        }

        for (int i = 0; i < baseDatos.size(); i++) {
            if (baseDatos.get(i).getId().equals(pago.getId())) {
                baseDatos.set(i, pago);
                System.out.println("PAGO ACTUALIZADO: " + pago.getId());
                return;
            }
        }
        baseDatos.add(pago);
        System.out.println("PAGO REGISTRADO: " + pago.getId() + " - " + pago.getEstado());
    }

    @Override
    public void registrarPago(Pago pago) {
        guardar(pago);
    }

    @Override
    public Pago buscarPorId(String id) {
        for (Pago p : baseDatos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Pago> listarTodos() {
        return baseDatos;
    }
}
