package src.dominio.entidades;

public class DetalleVenta {

    private int idDetalleVenta;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private ProductoComercial productoComercial;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int cantidad,
                        double precioUnitario, double subtotal,
                        ProductoComercial productoComercial) {

        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.productoComercial = productoComercial;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoComercial getProductoComercial() {
        return productoComercial;
    }

    public void setProductoComercial(ProductoComercial productoComercial) {
        this.productoComercial = productoComercial;
    }
}