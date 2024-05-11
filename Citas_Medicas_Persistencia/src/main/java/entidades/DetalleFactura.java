package entidades;

/**
 * La clase DetalleFactura representa un detalle de una factura médica.
 */
public class DetalleFactura {
    
    /**
     * La cantidad del producto o servicio.
     */
    private Integer cantidad;
    
    /**
     * La unidad de medida del producto o servicio.
     */
    private String unidad;
    
    /**
     * La clave de la unidad de medida del producto o servicio.
     */
    private String claveUnidad;
    
    /**
     * La clave del producto o servicio.
     */
    private String claveProducto;
    
    /**
     * La descripción del producto o servicio.
     */
    private String descripcion;
    
    /**
     * El valor unitario del producto o servicio.
     */
    private Float valorUnitario;
    
    /**
     * El importe total del detalle.
     */
    private Float importe;

    /**
     * Constructor por defecto de la clase DetalleFactura.
     */
    public DetalleFactura() {
    }

    /**
     * Constructor de la clase DetalleFactura.
     * @param cantidad La cantidad del producto o servicio.
     * @param unidad La unidad de medida del producto o servicio.
     * @param claveUnidad La clave de la unidad de medida del producto o servicio.
     * @param claveProducto La clave del producto o servicio.
     * @param descripcion La descripción del producto o servicio.
     * @param valorUnitario El valor unitario del producto o servicio.
     * @param importe El importe total del detalle.
     */
    public DetalleFactura(Integer cantidad, String unidad, String claveUnidad, String claveProducto, String descripcion, Float valorUnitario, Float importe) {
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.claveUnidad = claveUnidad;
        this.claveProducto = claveProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
    }

    /**
     * Obtiene la cantidad del producto o servicio.
     * @return La cantidad del producto o servicio.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto o servicio.
     * @param cantidad La cantidad del producto o servicio a establecer.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la unidad de medida del producto o servicio.
     * @return La unidad de medida del producto o servicio.
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Establece la unidad de medida del producto o servicio.
     * @param unidad La unidad de medida del producto o servicio a establecer.
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * Obtiene la clave de la unidad de medida del producto o servicio.
     * @return La clave de la unidad de medida del producto o servicio.
     */
    public String getClaveUnidad() {
        return claveUnidad;
    }

    /**
     * Establece la clave de la unidad de medida del producto o servicio.
     * @param claveUnidad La clave de la unidad de medida del producto o servicio a establecer.
     */
    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    /**
     * Obtiene la clave del producto o servicio.
     * @return La clave del producto o servicio.
     */
    public String getClaveProducto() {
        return claveProducto;
    }

    /**
     * Establece la clave del producto o servicio.
     * @param claveProducto La clave del producto o servicio a establecer.
     */
    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    /**
     * Obtiene la descripción del producto o servicio.
     * @return La descripción del producto o servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto o servicio.
     * @param descripcion La descripción del producto o servicio a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el valor unitario del producto o servicio.
     * @return El valor unitario del producto o servicio.
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Establece el valor unitario del producto o servicio.
     * @param valorUnitario El valor unitario del producto o servicio a establecer.
     */
    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Obtiene el importe total del detalle.
     * @return El importe total del detalle.
     */
    public Float getImporte() {
        return importe;
    }

    /**
     * Establece el importe total del detalle.
     * @param importe El importe total del detalle a establecer.
     */
    public void setImporte(Float importe) {
        this.importe = importe;
    }

    /**
     * Devuelve una representación de cadena de este detalle de factura.
     * @return Una cadena que representa este detalle de factura.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetalleFactura{");
        sb.append("cantidad=").append(cantidad);
        sb.append(", unidad=").append(unidad);
        sb.append(", claveUnidad=").append(claveUnidad);
        sb.append(", claveProducto=").append(claveProducto);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", valorUnitario=").append(valorUnitario);
        sb.append(", importe=").append(importe);
        sb.append('}');
        return sb.toString();
    }
    
}
