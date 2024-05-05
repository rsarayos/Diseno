package objetosNegocio;

import dtos.FacturaDTO;
import excepcionesNegocio.NegocioException;

/**
 *
 * @author alex_
 */
public interface IFacturacionNegocio {
    
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException;
    
}
