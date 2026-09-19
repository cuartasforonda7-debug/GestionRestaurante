package app.dominio.entidades;

import java.time.LocalDateTime;

public class Empleado extends Usuario {

    private LocalDateTime fechaIngreso;
    private Rol rol;

    // === CONSTRUCTOR VACIO ===
    public Empleado() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public Empleado(int idUsuario, String nombre, String email,
                    String telefono, String contrasena, boolean estado,
                    LocalDateTime fechaRegistro,
                    LocalDateTime fechaIngreso, Rol rol) {

        super(idUsuario, nombre, email, telefono, contrasena, estado, fechaRegistro);

        this.fechaIngreso = fechaIngreso;
        this.rol = rol;
    }

    // Getters y Setters

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
