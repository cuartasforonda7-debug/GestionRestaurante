import app.aplicacion.servicios.RegistrarPagoUseCase;
import app.backend.infraestructura.repositorio.PagoRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        var repo = new PagoRepositoryImpl();
        var useCase = new RegistrarPagoUseCase(repo);

        useCase.ejecutar(50000, "NEQUI", "COMP-123");

        System.out.println("PAGO REGISTRADO: $" );
    }
}
        

