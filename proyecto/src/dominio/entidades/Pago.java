package src.dominio.entidades;
import java.time.LocalDateTime;

public class Pago {

    private int idPago;
    private LocalDateTime fecha;
    private double monto;
    private String metodo;
    private String estado;
    private String comprobante;

    // === CONSTRUCTOR VACIO ===
    public Pago() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public Pago(int idPago, LocalDateTime fecha, double monto,
                String metodo, String estado, String comprobante) {

        this.idPago = idPago;
        this.fecha = fecha;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
        this.comprobante = comprobante;
    }

    // Getters y Setters

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }
}