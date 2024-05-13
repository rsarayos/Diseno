package dtos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * La clase FacturaDTO representa una factura en formato DTO (Data Transfer Object).
 */
public class FacturaDTO {

    /**
     * El número interno de folio de la factura.
     */
    private Integer folioInterno;

    /**
     * El folio fiscal de la factura.
     */
    private String folioFiscal;

    /**
     * La fecha en que la factura fue timbrada.
     */
    private Date fechaTimbrado;

    /**
     * El médico que emitió la factura.
     */
    private MedicoDTO emisor;

    /**
     * El paciente al que se emitió la factura.
     */
    private PacienteDTO receptor;

    /**
     * Los detalles de la factura.
     */
    private List<DetalleFacturaDTO> detallesFactura;

    /**
     * El uso del CFDI (Comprobante Fiscal Digital por Internet) de la factura.
     */
    private String usoCFDI;

    /**
     * La forma de pago de la factura.
     */
    private String formaPago;

    /**
     * El método de pago de la factura.
     */
    private String metodoPago;

    /**
     * El subtotal de la factura.
     */
    private Float subTotal;

    /**
     * El impuesto total de la factura.
     */
    private Float impuesto;

    /**
     * El total de la factura.
     */
    private Float total;

    /**
     * Constructor de la clase FacturaDTO.
     * @param folioInterno El número interno de folio de la factura.
     * @param fechaTimbrado La fecha en que la factura fue timbrada.
     * @param emisor El médico que emitió la factura.
     * @param receptor El paciente al que se emitió la factura.
     * @param detallesFactura Los detalles de la factura.
     * @param usoCFDI El uso del CFDI de la factura.
     * @param formaPago La forma de pago de la factura.
     * @param metodoPago El método de pago de la factura.
     * @param subTotal El subtotal de la factura.
     * @param impuesto El impuesto total de la factura.
     * @param total El total de la factura.
     */
    public FacturaDTO(Integer folioInterno, Date fechaTimbrado, MedicoDTO emisor, PacienteDTO receptor, List<DetalleFacturaDTO> detallesFactura, String usoCFDI, String formaPago, String metodoPago, Float subTotal, Float impuesto, Float total) {
        this.folioInterno = folioInterno;
        this.fechaTimbrado = fechaTimbrado;
        this.emisor = emisor;
        this.receptor = receptor;
        this.detallesFactura = detallesFactura;
        this.usoCFDI = usoCFDI;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    /**
     * Obtiene el folio fiscal de la factura.
     * @return El folio fiscal de la factura.
     */
    public String getFolioFiscal() {
        return folioFiscal;
    }

    /**
     * Establece el folio fiscal de la factura.
     * @param folioFiscal El folio fiscal de la factura a establecer.
     */
    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    /**
     * Obtiene el número interno de folio de la factura.
     * @return El número interno de folio de la factura.
     */
    public Integer getFolioInterno() {
        return folioInterno;
    }

    /**
     * Obtiene la fecha en que la factura fue timbrada.
     * @return La fecha de timbrado de la factura.
     */
    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    /**
     * Obtiene el médico que emitió la factura.
     * @return El médico que emitió la factura.
     */
    public MedicoDTO getEmisor() {
        return emisor;
    }

    /**
     * Obtiene el paciente al que se emitió la factura.
     * @return El paciente al que se emitió la factura.
     */
    public PacienteDTO getReceptor() {
        return receptor;
    }

    /**
     * Obtiene los detalles de la factura.
     * @return Los detalles de la factura.
     */
    public List<DetalleFacturaDTO> getDetallesFactura() {
        return detallesFactura;
    }

    /**
     * Obtiene el uso del CFDI de la factura.
     * @return El uso del CFDI de la factura.
     */
    public String getUsoCFDI() {
        return usoCFDI;
    }

    /**
     * Obtiene la forma de pago de la factura.
     * @return La forma de pago de la factura.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Obtiene el método de pago de la factura.
     * @return El método de pago de la factura.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Obtiene el subtotal de la factura.
     * @return El subtotal de la factura.
     */
    public Float getSubTotal() {
        return subTotal;
    }

    /**
     * Obtiene el impuesto total de la factura.
     * @return El impuesto total de la factura.
     */
    public Float getImpuesto() {
        return impuesto;
    }

    /**
     * Obtiene el total de la factura.
     * @return El total de la factura.
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Devuelve una representación de cadena de esta factura DTO.
     * @return Una cadena que representa esta factura DTO.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FacturaDTO{");
        sb.append("folioInterno=").append(folioInterno);
        sb.append(", fechaTimbrado=").append(fechaTimbrado);
        sb.append(", emisor=").append(emisor);
        sb.append(", receptor=").append(receptor);
        sb.append(", detallesFactura=").append(detallesFactura);
        sb.append(", usoCFDI=").append(usoCFDI);
        sb.append(", formaPago=").append(formaPago);
        sb.append(", metodoPago=").append(metodoPago);
        sb.append(", subTotal=").append(subTotal);
        sb.append(", impuesto=").append(impuesto);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }

}
