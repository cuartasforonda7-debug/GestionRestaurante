package src.dominio.entidades;
public class OpcionMenu {

    private int idOpcionMenu;
    private String categoria;
    private int eleccionesPermitidas;
    private boolean estado;

    // === CONSTRUCTOR VACIO ===
    public OpcionMenu() {
    }

    // === CONSTRUCTOR COMPLETO ===
    public OpcionMenu(int idOpcionMenu, String categoria,
                    int eleccionesPermitidas, boolean estado) {

        this.idOpcionMenu = idOpcionMenu;
        this.categoria = categoria;
        this.eleccionesPermitidas = eleccionesPermitidas;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdOpcionMenu() {
        return idOpcionMenu;
    }

    public void setIdOpcionMenu(int idOpcionMenu) {
        this.idOpcionMenu = idOpcionMenu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEleccionesPermitidas() {
        return eleccionesPermitidas;
    }

    public void setEleccionesPermitidas(int eleccionesPermitidas) {
        this.eleccionesPermitidas = eleccionesPermitidas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}