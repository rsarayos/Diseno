package facturacion;

/**
 *
 * @author alex_
 */
public class DetalleFacturaReporte {
 
    private String cantidad;
    private String unidad;
    private String claveUnidad;
    private String claveProducto;
    private String descripcion;
    private String valorUnitario;
    private String importe;

    public DetalleFacturaReporte() {
    }

    public DetalleFacturaReporte(String cantidad, String unidad, String claveUnidad, String claveProducto, String descripcion, String valorUnitario, String importe) {
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.claveUnidad = claveUnidad;
        this.claveProducto = claveProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
    
    
    
}
