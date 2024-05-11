package facturacion;

/**
 * Clase que representa un detalle de factura para un reporte.
 */
public class DetalleFacturaReporte {
 
    private String cantidad;
    private String unidad;
    private String claveUnidad;
    private String claveProducto;
    private String descripcion;
    private String valorUnitario;
    private String importe;

    /**
     * Constructor sin parámetros de la clase DetalleFacturaReporte.
     */
    public DetalleFacturaReporte() {
    }

    /**
     * Constructor con parámetros de la clase DetalleFacturaReporte.
     * 
     * @param cantidad La cantidad del detalle.
     * @param unidad La unidad del detalle.
     * @param claveUnidad La clave de unidad del detalle.
     * @param claveProducto La clave del producto del detalle.
     * @param descripcion La descripción del detalle.
     * @param valorUnitario El valor unitario del detalle.
     * @param importe El importe del detalle.
     */
    public DetalleFacturaReporte(String cantidad, String unidad, String claveUnidad, String claveProducto, String descripcion, String valorUnitario, String importe) {
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.claveUnidad = claveUnidad;
        this.claveProducto = claveProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
    }

    /**
     * Método para obtener la cantidad del detalle.
     * 
     * @return La cantidad del detalle.
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Método para establecer la cantidad del detalle.
     * 
     * @param cantidad La cantidad del detalle a establecer.
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método para obtener la unidad del detalle.
     * 
     * @return La unidad del detalle.
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Método para establecer la unidad del detalle.
     * 
     * @param unidad La unidad del detalle a establecer.
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * Método para obtener la clave de unidad del detalle.
     * 
     * @return La clave de unidad del detalle.
     */
    public String getClaveUnidad() {
        return claveUnidad;
    }

    /**
     * Método para establecer la clave de unidad del detalle.
     * 
     * @param claveUnidad La clave de unidad del detalle a establecer.
     */
    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    /**
     * Método para obtener la clave del producto del detalle.
     * 
     * @return La clave del producto del detalle.
     */
    public String getClaveProducto() {
        return claveProducto;
    }

    /**
     * Método para establecer la clave del producto del detalle.
     * 
     * @param claveProducto La clave del producto del detalle a establecer.
     */
    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    /**
     * Método para obtener la descripción del detalle.
     * 
     * @return La descripción del detalle.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción del detalle.
     * 
     * @param descripcion La descripción del detalle a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el valor unitario del detalle.
     * 
     * @return El valor unitario del detalle.
     */
    public String getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Método para establecer el valor unitario del detalle.
     * 
     * @param valorUnitario El valor unitario del detalle a establecer.
     */
    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Método para obtener el importe del detalle.
     * 
     * @return El importe del detalle.
     */
    public String getImporte() {
        return importe;
    }

    /**
     * Método para establecer el importe del detalle.
     * 
     * @param importe El importe del detalle a establecer.
     */
    public void setImporte(String importe) {
        this.importe = importe;
    }
    
}
