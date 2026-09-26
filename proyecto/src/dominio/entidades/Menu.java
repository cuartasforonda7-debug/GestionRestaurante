package src.dominio.entidades;
public class Menu {

    private int idMenu;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private boolean estado;

    // === CONSTRUCTOR VACIO ===

    public Menu() {
    }

    // CONSTRUCTOR COMPLETO ===

    public Menu(int idMenu, String nombre, String descripcion,
                double precioBase, boolean estado) {

        this.idMenu = idMenu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
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

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}