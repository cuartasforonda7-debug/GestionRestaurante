package dominio.entidades;

import java.time.LocalDateTime;

public class Empleado extends Usuario {

    private LocalDateTime fechaIngreso;

    // === CONSTRUCTOR VACIO ===
    public Empleado() {
        super();
        this.fechaIngreso = LocalDateTime.now();
    }

    // === CONSTRUCTOR COMPLETO ===
    public Empleado(int idUsuario, String nombre, String email,
                    String telefono, String contrasena, boolean estado,
                    LocalDateTime fechaRegistro,
                    LocalDateTime fechaIngreso, Rol rol) {

        super(idUsuario, nombre, email, telefono, contrasena, estado, fechaRegistro, rol);
        this.fechaIngreso = fechaIngreso != null ? fechaIngreso : LocalDateTime.now();
    }

    // Getters y Setters
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Empleado #" + getIdUsuario() + " | " + getNombre() + " (" + getEmail() + ")"
                + " | Rol: " + (getRol() != null ? getRol().getNombre() : "Sin Rol")
                + " | Ingreso: " + (fechaIngreso != null ? fechaIngreso.toLocalDate() : "N/A")
                + " | Estado: " + (isEstado() ? "Activo" : "Inactivo");
    }
}
