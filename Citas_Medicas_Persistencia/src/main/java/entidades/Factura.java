package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author alex_
 */
public class Factura {
    
    private Integer folioInterno;
    private String folioFiscal;
    private Date fechaTimbrado;
    private String rfcMedico;
    private String rfcPaciente;
    private List<DetalleFactura> detallesFactura;
    private String usoCFDI;
    private String formaPago;
    private String metodoPago;
    private Float subTotal;
    private Float impuesto;
    private Float total;

    public Factura() {
    }

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

    public Integer getFolioInterno() {
        return folioInterno;
    }

    public void setFolioInterno(Integer folioInterno) {
        this.folioInterno = folioInterno;
    }

    public String getFolioFiscal() {
        return folioFiscal;
    }

    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getRfcMedico() {
        return rfcMedico;
    }

    public void setRfcMedico(String rfcMedico) {
        this.rfcMedico = rfcMedico;
    }

    public String getRfcPaciente() {
        return rfcPaciente;
    }

    public void setRfcPaciente(String rfcPaciente) {
        this.rfcPaciente = rfcPaciente;
    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    public String getUsoCFDI() {
        return usoCFDI;
    }

    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
}
