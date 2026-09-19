import app.dominio.entidades.Cliente;
import app.dominio.entidades.Domicilio;
import app.dominio.entidades.Empleado;
import app.dominio.entidades.Rol;
import app.dominio.entidades.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        // CREAR UN ROL
        Rol rol = new Rol(
            1,
            "Cajera",
            "Gestiona ventas, pagos e inventario"
        );
        // CREAR UN EMPLEADO
        Empleado empleado = new Empleado(
                            1,
                "Laura",
                "laura@restaurante.com",
                "3001234567",
                "123456",
                true,
                LocalDateTime.now(),
                LocalDateTime.now(),
                rol
        );
        
        // CREAR UN DOMICILIO
        Domicilio domicilio = new Domicilio(
            1,
            "Carrera 50 # 45-20",
            "Apartamento 302",
            "3009876543"
        );

        // CREAR UN CLIENTE
        Cliente cliente = new Cliente(
            2,
            "Cristian",
            "cristian@gmail.com",
            "3011234567",
            "123456",
            true,
            LocalDateTime.now(),
            new ArrayList<>()
        );

            cliente.getDomicilios().add(domicilio);

        // Mostrar información
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Rol: " + empleado.getRol().getNombre());

        System.out.println();

        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Domicilio: " +
                cliente.getDomicilios().get(0).getDireccion());

        // Polimorfismo
        Usuario usuario1 = cliente;
        Usuario usuario2 = empleado;

        System.out.println();
        System.out.println("=== POLIMORFISMO ===");

        System.out.println("Usuario 1: " + usuario1.getNombre());
        System.out.println("Usuario 2: " + usuario2.getNombre());
    }
}
