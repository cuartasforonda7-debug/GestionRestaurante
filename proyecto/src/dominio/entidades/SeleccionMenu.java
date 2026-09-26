package src.dominio.entidades;

public class SeleccionMenu {

    private int idSeleccion;
    private OpcionMenu opcionMenu;
    private Producto producto;

    // === CONSTRUCTOR VACIO ===
    
    public SeleccionMenu() {
    }

    // === CONSTRUCTOR COMPLETO ===

    public SeleccionMenu(int idSeleccion, OpcionMenu opcionMenu,
                        Producto producto) {

        this.idSeleccion = idSeleccion;
        this.opcionMenu = opcionMenu;
        this.producto = producto;
    }

    // Getters y Setters

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public OpcionMenu getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(OpcionMenu opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}