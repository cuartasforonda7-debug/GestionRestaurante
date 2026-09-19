package app.dominio.entidades;

public class DetallePedido {

    private int idDetallePedido;
    private int cantidad;
    private double precioUnitario;
    private ProductoComercial productoComercial;

    // === CONSTRUCTOR VACIO ===
    public DetallePedido() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public DetallePedido(int idDetallePedido, int cantidad,
                         double precioUnitario) {

        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}