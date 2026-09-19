package app.dominio.entidades;

import java.time.LocalDateTime;

public class Pedido {

    private int idPedido;
    private LocalDateTime fecha;
    private String estado;
    private String observacion;

    // === CONSTRUCTOR VACIO ===
    public Pedido() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public Pedido(int idPedido, LocalDateTime fecha,
                  String estado, String observacion) {

        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
    }

    // Getters y Setters

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}