package app.dominio.entidades;

import java.time.LocalDateTime;

public class Usuario {

    // === ATRIBUTOS ===

    private int idUsuario;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;
    private boolean estado;
    private LocalDateTime fechaRegistro;


    // === CONSTRUCTOR VACIO ===

    public Usuario() {

    }

    // === CONSTRUCTOR COMPLETO ===


    public Usuario(int idUsuario, String nombre, String email, String telefono,
                    String contrasena, boolean estado, LocalDateTime fechaRegistro) {

            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
            this.contrasena = contrasena;
            this.estado = estado;
            this.fechaRegistro = fechaRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}

