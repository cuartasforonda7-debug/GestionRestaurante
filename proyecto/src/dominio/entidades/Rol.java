package dominio.entidades;

import java.util.Objects;

public class Rol {

    // === CONSTANTES DE ROLES PREDEFINIDOS EN EL RESTAURANTE ===
    public static final String ROL_ADMINISTRADOR = "Administrador";
    public static final String ROL_MESERO = "Mesero";
    public static final String ROL_COCINERO = "Cocinero";
    public static final String ROL_CAJERO = "Cajero";
    public static final String ROL_DOMICILIARIO = "Domiciliario";
    public static final String ROL_CLIENTE = "Cliente";

    // ATRIBUTOS
    private int idRol;
    private String nombre;
    private String descripcion;

    // === CONSTRUCTOR VACIO ===
    public Rol() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public Rol(int idRol, String nombre, String descripcion) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return idRol == rol.idRol || Objects.equals(nombre, rol.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, nombre);
    }

    @Override
    public String toString() {
        return "[" + idRol + "] " + nombre + " (" + descripcion + ")";
    }
}
