package dtos;

/**
 * La clase DetalleFacturaDTO representa un detalle de una factura en formato DTO (Data Transfer Object).
 */
public class DetalleFacturaDTO {
    
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
     * Constructor de la clase DetalleFacturaDTO.
     * @param cantidad La cantidad del producto o servicio.
     * @param unidad La unidad de medida del producto o servicio.
     * @param claveUnidad La clave de la unidad de medida del producto o servicio.
     * @param claveProducto La clave del producto o servicio.
     * @param descripcion La descripción del producto o servicio.
     * @param valorUnitario El valor unitario del producto o servicio.
     * @param importe El importe total del detalle.
     */
    public DetalleFacturaDTO(Integer cantidad, String unidad, String claveUnidad, String claveProducto, String descripcion, Float valorUnitario, Float importe) {
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
     * Obtiene la unidad de medida del producto o servicio.
     * @return La unidad de medida del producto o servicio.
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Obtiene la clave de la unidad de medida del producto o servicio.
     * @return La clave de la unidad de medida del producto o servicio.
     */
    public String getClaveUnidad() {
        return claveUnidad;
    }

    /**
     * Obtiene la clave del producto o servicio.
     * @return La clave del producto o servicio.
     */
    public String getClaveProducto() {
        return claveProducto;
    }

    /**
     * Obtiene la descripción del producto o servicio.
     * @return La descripción del producto o servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el valor unitario del producto o servicio.
     * @return El valor unitario del producto o servicio.
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Obtiene el importe total del detalle.
     * @return El importe total del detalle.
     */
    public Float getImporte() {
        return importe;
    }

    /**
     * Devuelve una representación de cadena de este detalle de factura DTO.
     * @return Una cadena que representa este detalle de factura DTO.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetalleFacturaDTO{");
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
