package ar.edu.unju.fi.ejercicio5.model;

/**
 * Clase Producto que representa un producto
 * @autor Velazquez Mauricio Nehuen
 * @version 1.0
 */
public class Producto {
    private String codigo;
    private String descripcion;
    private Double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private Boolean estado;

    public enum OrigenFabricacion{
        ARGENTINA, CHINA, BRASIL, URUGUAY
    }

    public enum Categoria{
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
    }

    /**
     * Constructor parametrizado de la clase Producto
     * @param codigo codigo de producto
     * @param descripcion descripcion del producto
     * @param precioUnitario precio unitario del producto
     * @param origenFabricacion origen de fabricacion del producto
     * @param categoria categoria del producto
     * @param estado disponibilidad del producto
     */
    public Producto(String codigo, String descripcion, Double precioUnitario,
                    OrigenFabricacion origenFabricacion, Categoria categoria, Boolean estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", origenFabricacion=" + origenFabricacion +
                ", categoria=" + categoria +
                ", estado=" + estado +
                '}';
    }
}
