package src.dominio.entidades;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Domicilio> domicilios;

    // === CONSTRUCTOR VACIO ===
    public Cliente() {
        this.domicilios = new ArrayList<>();
    }

    // === CONSTRUCTOR COMPLETO ===
    public Cliente(int idUsuario, String nombre, String email, String telefono,
                String contrasena, boolean estado,
                java.time.LocalDateTime fechaRegistro,
                List<Domicilio> domicilios) {

        super(idUsuario, nombre, email, telefono, contrasena, estado, fechaRegistro);

        this.domicilios = domicilios;
    }

    // Getter

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    // Setter
    
    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}
