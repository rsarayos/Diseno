package dtos;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author alex_
 */
public class FacturaDTO {
    
    private Integer folioInterno;
    private String folioFiscal;
    private Calendar fechaTimbrado;
    private MedicoDTO emisor;
    private PacienteDTO receptor;
    private List<DetalleFacturaDTO> detallesFactura;
    private String usoCFDI;
    private String formaPago;
    private String metodoPago;
    private Float subTotal;
    private Float impuesto;
    private Float total;

    public FacturaDTO(Integer folioInterno, Calendar fechaTimbrado, MedicoDTO emisor, PacienteDTO receptor, List<DetalleFacturaDTO> detallesFactura, String usoCFDI, String formaPago, String metodoPago, Float subTotal, Float impuesto, Float total) {
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

    public String getFolioFiscal() {
        return folioFiscal;
    }

    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    public Integer getFolioInterno() {
        return folioInterno;
    }

    public Calendar getFechaTimbrado() {
        return fechaTimbrado;
    }

    public MedicoDTO getEmisor() {
        return emisor;
    }

    public PacienteDTO getReceptor() {
        return receptor;
    }

    public List<DetalleFacturaDTO> getDetallesFactura() {
        return detallesFactura;
    }

    public String getUsoCFDI() {
        return usoCFDI;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public Float getTotal() {
        return total;
    }

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
