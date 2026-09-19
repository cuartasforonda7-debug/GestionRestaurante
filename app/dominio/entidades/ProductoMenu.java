package app.dominio.entidades;

public class ProductoMenu {

    private int idProductoMenu;
    private double cantidadConsumo;
    private boolean estado;

    // === CONSTRUCTOR VACIO ===
    public ProductoMenu() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public ProductoMenu(int idProductoMenu, double cantidadConsumo,
                        boolean estado) {

        this.idProductoMenu = idProductoMenu;
        this.cantidadConsumo = cantidadConsumo;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdProductoMenu() {
        return idProductoMenu;
    }

    public void setIdProductoMenu(int idProductoMenu) {
        this.idProductoMenu = idProductoMenu;
    }

    public double getCantidadConsumo() {
        return cantidadConsumo;
    }

    public void setCantidadConsumo(double cantidadConsumo) {
        this.cantidadConsumo = cantidadConsumo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}