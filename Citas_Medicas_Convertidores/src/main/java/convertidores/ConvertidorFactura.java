package convertidores;

import dtos.DetalleFacturaDTO;
import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import entidades.DetalleFactura;
import entidades.Factura;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que proporciona métodos para convertir objetos de tipo FacturaDTO a objetos de tipo Factura.
 */
public class ConvertidorFactura {

    /**
     * Constructor por defecto de la clase ConvertidorFactura.
     */
    public ConvertidorFactura() {
    }
    
    /**
     * Convierte un objeto de tipo FacturaDTO a un objeto de tipo Factura.
     *
     * @param f El objeto de tipo FacturaDTO a convertir.
     * @return El objeto de tipo Factura resultante de la conversión.
     */
    public Factura DTOAEntidad(FacturaDTO f) {
        
        List<DetalleFactura> detalles = new LinkedList<>();
        
        for (DetalleFacturaDTO d : f.getDetallesFactura()) {
            DetalleFactura detalle = new DetalleFactura(
                    d.getCantidad(), 
                    d.getUnidad(), 
                    d.getClaveUnidad(), 
                    d.getClaveProducto(), 
                    d.getDescripcion(), 
                    d.getValorUnitario(), 
                    d.getImporte());
            
            detalles.add(detalle);
        }
        
        return new Factura(
                f.getFolioInterno(), 
                f.getFolioFiscal(), 
                f.getFechaTimbrado(), 
                f.getEmisor().getDatosFiscales().get(0).getRFC(), 
                f.getReceptor().getDatosFiscales().get(0).getRFC(), 
                detalles, 
                f.getUsoCFDI(), 
                f.getFormaPago(), 
                f.getMetodoPago(), 
                f.getSubTotal(), 
                f.getImpuesto(), 
                f.getTotal());
        
    }
    
    
}
