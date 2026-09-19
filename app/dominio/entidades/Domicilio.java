package app.dominio.entidades;

public class Domicilio {
    
    // ATRIBUTOS 

    private int idDomicilio;
    private String direccion;
    private String detalleUbicacion;
    private String telefonoContacto;

    // === CONSTRUCTOR VACIO ===

    public Domicilio() {

    }
    
    // === CONSTRUCTOR COMPLETO ===

    public Domicilio(int idDomicilio, String direccion,
                    String detalleUbicacion, String telefonoContacto) {

        this.idDomicilio = idDomicilio;
        this.direccion = direccion;
        this.detalleUbicacion = detalleUbicacion;
        this.telefonoContacto = telefonoContacto;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDetalleUbicacion() {
        return detalleUbicacion;
    }

    public void setDetalleUbicacion(String detalleUbicacion) {
        this.detalleUbicacion = detalleUbicacion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}
