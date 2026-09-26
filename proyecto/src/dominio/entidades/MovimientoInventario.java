package src.dominio.entidades;

import java.time.LocalDateTime;

public class MovimientoInventario {
    private int idMovimiento;
    private String tipo;
    private double cantidad;
    private String motivo;
    private LocalDateTime fecha;
    private String observacion;

    // Constructor vacío
    public MovimientoInventario() {
    }

    // Constructor completo
    public MovimientoInventario(int idMovimiento, String tipo,
                                double cantidad, String motivo,
                                LocalDateTime fecha, String observacion) {

        this.idMovimiento = idMovimiento;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    // Getters y Setters

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
