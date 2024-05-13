package entidades;

import java.util.Date;
import java.util.List;

/**
 * La clase Factura representa una factura médica.
 */
public class Factura {
    
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
     * El RFC del médico que emitió la factura.
     */
    private String rfcMedico;
    
    /**
     * El RFC del paciente al que se emitió la factura.
     */
    private String rfcPaciente;
    
    /**
     * Los detalles de la factura.
     */
    private List<DetalleFactura> detallesFactura;
    
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
     * Constructor por defecto de la clase Factura.
     */
    public Factura() {
    }

    /**
     * Constructor de la clase Factura.
     * @param folioInterno El número interno de folio de la factura.
     * @param folioFiscal El folio fiscal de la factura.
     * @param fechaTimbrado La fecha en que la factura fue timbrada.
     * @param rfcMedico El RFC del médico que emitió la factura.
     * @param rfcPaciente El RFC del paciente al que se emitió la factura.
     * @param detallesFactura Los detalles de la factura.
     * @param usoCFDI El uso del CFDI de la factura.
     * @param formaPago La forma de pago de la factura.
     * @param metodoPago El método de pago de la factura.
     * @param subTotal El subtotal de la factura.
     * @param impuesto El impuesto total de la factura.
     * @param total El total de la factura.
     */
    public Factura(Integer folioInterno, String folioFiscal, Date fechaTimbrado, String rfcMedico, String rfcPaciente, List<DetalleFactura> detallesFactura, String usoCFDI, String formaPago, String metodoPago, Float subTotal, Float impuesto, Float total) {
        this.folioInterno = folioInterno;
        this.folioFiscal = folioFiscal;
        this.fechaTimbrado = fechaTimbrado;
        this.rfcMedico = rfcMedico;
        this.rfcPaciente = rfcPaciente;
        this.detallesFactura = detallesFactura;
        this.usoCFDI = usoCFDI;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    /**
     * Obtiene el número interno de folio de la factura.
     * @return El número interno de folio.
     */
    public Integer getFolioInterno() {
        return folioInterno;
    }

    /**
     * Establece el número interno de folio de la factura.
     * @param folioInterno El número interno de folio a establecer.
     */
    public void setFolioInterno(Integer folioInterno) {
        this.folioInterno = folioInterno;
    }

    /**
     * Obtiene el folio fiscal de la factura.
     * @return El folio fiscal.
     */
    public String getFolioFiscal() {
        return folioFiscal;
    }

    /**
     * Establece el folio fiscal de la factura.
     * @param folioFiscal El folio fiscal a establecer.
     */
    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    /**
     * Obtiene la fecha en que la factura fue timbrada.
     * @return La fecha de timbrado.
     */
    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    /**
     * Establece la fecha en que la factura fue timbrada.
     * @param fechaTimbrado La fecha de timbrado a establecer.
     */
    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    /**
     * Obtiene el RFC del médico que emitió la factura.
     * @return El RFC del médico.
     */
    public String getRfcMedico() {
        return rfcMedico;
    }

    /**
     * Establece el RFC del médico que emitió la factura.
     * @param rfcMedico El RFC del médico a establecer.
     */
    public void setRfcMedico(String rfcMedico) {
        this.rfcMedico = rfcMedico;
    }

    /**
     * Obtiene el RFC del paciente al que se emitió la factura.
     * @return El RFC del paciente.
     */
    public String getRfcPaciente() {
        return rfcPaciente;
    }

    /**
     * Establece el RFC del paciente al que se emitió la factura.
     * @param rfcPaciente El RFC del paciente a establecer.
     */
    public void setRfcPaciente(String rfcPaciente) {
        this.rfcPaciente = rfcPaciente;
    }

    /**
     * Obtiene los detalles de la factura.
     * @return La lista de detalles de la factura.
     */
    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    /**
     * Establece los detalles de la factura.
     * @param detallesFactura La lista de detalles de la factura a establecer.
     */
    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    /**
     * Obtiene el uso del CFDI de la factura.
     * @return El uso del CFDI.
     */
    public String getUsoCFDI() {
        return usoCFDI;
    }

    /**
     * Establece el uso del CFDI de la factura.
     * @param usoCFDI El uso del CFDI a establecer.
     */
    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }

    /**
     * Obtiene la forma de pago de la factura.
     * @return La forma de pago.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Establece la forma de pago de la factura.
     * @param formaPago La forma de pago a establecer.
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Obtiene el método de pago de la factura.
     * @return El método de pago.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Establece el método de pago de la factura.
     * @param metodoPago El método de pago a establecer.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Obtiene el subtotal de la factura.
     * @return El subtotal de la factura.
     */
    public Float getSubTotal() {
        return subTotal;
    }

    /**
     * Establece el subtotal de la factura.
     * @param subTotal El subtotal a establecer.
     */
    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Obtiene el impuesto total de la factura.
     * @return El impuesto total de la factura.
     */
    public Float getImpuesto() {
        return impuesto;
    }

    /**
     * Establece el impuesto total de la factura.
     * @param impuesto El impuesto total a establecer.
     */
    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * Obtiene el total de la factura.
     * @return El total de la factura.
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Establece el total de la factura.
     * @param total El total a establecer.
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * Devuelve una representación de cadena de esta factura.
     * @return Una cadena que representa esta factura.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura{");
        sb.append("folioInterno=").append(folioInterno);
        sb.append(", folioFiscal=").append(folioFiscal);
        sb.append(", fechaTimbrado=").append(fechaTimbrado);
        sb.append(", rfcMedico=").append(rfcMedico);
        sb.append(", rfcPaciente=").append(rfcPaciente);
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
