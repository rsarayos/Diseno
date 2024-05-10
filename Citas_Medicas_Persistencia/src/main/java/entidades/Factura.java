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
    
    
    
}
