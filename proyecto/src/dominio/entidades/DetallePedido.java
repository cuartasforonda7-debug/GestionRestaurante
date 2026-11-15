package dominio.entidades;

public class DetallePedido {

    private int idDetallePedido;
    private int cantidad;
    private double precioUnitario;
    private ProductoComercial productoComercial;

    // === CONSTRUCTOR VACIO ===
    public DetallePedido() {
    }

    // === CONSTRUCTOR PARCIAL ===
    public DetallePedido(int idDetallePedido, int cantidad, double precioUnitario) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // === CONSTRUCTOR COMPLETO ===
    public DetallePedido(int idDetallePedido, int cantidad, double precioUnitario, ProductoComercial productoComercial) {
        this(idDetallePedido, cantidad, precioUnitario);
        this.productoComercial = productoComercial;
    }

    // === GETTERS Y SETTERS ===

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

    public ProductoComercial getProductoComercial() {
        return productoComercial;
    }

    public void setProductoComercial(ProductoComercial productoComercial) {
        this.productoComercial = productoComercial;
    }

    // === LOGICA DE DOMINIO ===
    public double calcularSubtotal() {
        return this.cantidad * this.precioUnitario;
    }

    @Override
    public String toString() {
        String nombreProd = (productoComercial != null) ? productoComercial.getNombre() : "Sin producto";
        return cantidad + "x " + nombreProd + " ($" + precioUnitario + " c/u) = $" + calcularSubtotal();
    }
}
