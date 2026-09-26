package src.dominio.entidades;

public class ProductoComercial {

    private int idProductoComercial;
    private String nombre;
    private String tipo;
    private Producto producto;
    private Menu menu;
    private boolean estado;

    // === CONSTRUCTOR VACIO ===

    public ProductoComercial() {
    }

    // === CONSTRUCTOR COMPLETO ===

    public ProductoComercial(int idProductoComercial, String nombre,
                                String tipo, Producto producto,
                                Menu menu, boolean estado) {

        this.idProductoComercial = idProductoComercial;
        this.nombre = nombre;
        this.tipo = tipo;
        this.producto = producto;
        this.menu = menu;
        this.estado = estado;
    }

    public int getIdProductoComercial() {
        return idProductoComercial;
    }

    public void setIdProductoComercial(int idProductoComercial) {
        this.idProductoComercial = idProductoComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}