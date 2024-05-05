package dtos;

/**
 *
 * @author alex_
 */
public class DetalleFacturaDTO {
    
    private Integer cantidad;
    private String unidad;
    private String claveUnidad;
    private String claveProducto;
    private String descripcion;
    private Float valorUnitario;
    private Float importe;

    public DetalleFacturaDTO(Integer cantidad, String unidad, String claveUnidad, String claveProducto, String descripcion, Float valorUnitario, Float importe) {
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.claveUnidad = claveUnidad;
        this.claveProducto = claveProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public Float getImporte() {
        return importe;
    }
    
}
