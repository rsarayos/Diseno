package timbradofactura;

import dtos.FacturaDTO;
import java.util.UUID;

/**
 * Clase que simula el timbrado de una factura en el SAT
 * @author alex_
 */
public class TimbrarFactura {
    
    /**
     * Metodo que realiza el timbrado de una factura 
     * @param factura la factura a timbrar en el sistema del SAT
     * @return la factura ya timbrada en el sistema del SAT
     */
    public FacturaDTO timbrarFactura(FacturaDTO factura){
        UUID uuid = UUID.randomUUID();
        // Convierte el UUID a una cadena en formato estándar
        String uuidString = uuid.toString();
        // Remueve los guiones del UUID estándar para obtener el formato deseado
        uuidString = uuidString.replace("-", "");
        factura.setFolioFiscal(uuidString);
        return factura;   
    }
    
}
