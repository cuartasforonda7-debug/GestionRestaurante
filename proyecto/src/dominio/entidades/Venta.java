package src.dominio.entidades;
import java.time.LocalDateTime;

public class Venta {

    private int idVenta;
    private LocalDateTime fecha;
    private double subtotal;
    private double total;
    private String estado;

    // === CONSTRUCTOR VACIO ===

    public Venta() {
    }

    // === CONSTRUCTOR COMPLETO ===

    public Venta(int idVenta, LocalDateTime fecha, double subtotal,
                 double total, String estado) {

        this.idVenta = idVenta;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}