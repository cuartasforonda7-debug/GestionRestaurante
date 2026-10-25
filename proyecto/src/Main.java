import app.aplicacion.servicios.ConfirmarPagoUseCase;
import app.aplicacion.servicios.RegistrarPagoUseCase;
import app.backend.infraestructura.repositorio.PagoRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        var repo = new PagoRepositoryImpl();
        var registrar = new RegistrarPagoUseCase(repo);
        var confirmar = new ConfirmarPagoUseCase(repo);

        registrar.ejecutar(50000, "NEQUI", "COMP-123");
        System.out.println("PAGO REGISTRADO: 50000 - NEQUI ID 1");

        registrar.ejecutar(30000, "EFECTIVO", "COMP-456");
        System.out.println("PAGO REGISTRADO: 30000 - EFECTIVO ID 2");

        confirmar.ejecutar("1", true);
        System.out.println("PAGO CONFIRMADO: ID 1");

        confirmar.ejecutar("2", false);
        System.out.println("PAGO RECHAZADO: ID 2");

        System.out.println("Prueba HU-17 completa");
    }
}
        

