package src.dominio.entidades;

import java.time.LocalDateTime;

public class LiquidacionDomiciliario {

    private int idLiquidacion;
    private LocalDateTime fecha;
    private double montoBase;
    private double efectivoRecaudado;
    private double montoEsperado;
    private double montoEntregado;
    private double diferencia;
    private String estado;
    private String observacion;

    public LiquidacionDomiciliario() {
    }

    public LiquidacionDomiciliario(int idLiquidacion, LocalDateTime fecha,
                                    double montoBase, double efectivoRecaudado,
                                    double montoEsperado, double montoEntregado,
                                    double diferencia, String estado,
                                    String observacion) {

        this.idLiquidacion = idLiquidacion;
        this.fecha = fecha;
        this.montoBase = montoBase;
        this.efectivoRecaudado = efectivoRecaudado;
        this.montoEsperado = montoEsperado;
        this.montoEntregado = montoEntregado;
        this.diferencia = diferencia;
        this.estado = estado;
        this.observacion = observacion;
    }

    public int getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(int idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public double getEfectivoRecaudado() {
        return efectivoRecaudado;
    }

    public void setEfectivoRecaudado(double efectivoRecaudado) {
        this.efectivoRecaudado = efectivoRecaudado;
    }

    public double getMontoEsperado() {
        return montoEsperado;
    }

    public void setMontoEsperado(double montoEsperado) {
        this.montoEsperado = montoEsperado;
    }

    public double getMontoEntregado() {
        return montoEntregado;
    }

    public void setMontoEntregado(double montoEntregado) {
        this.montoEntregado = montoEntregado;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
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
