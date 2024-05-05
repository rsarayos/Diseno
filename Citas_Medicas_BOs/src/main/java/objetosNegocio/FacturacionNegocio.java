package objetosNegocio;

import dtos.FacturaDTO;
import excepcionesNegocio.NegocioException;

/**
 *
 * @author alex_
 */
public class FacturacionNegocio implements IFacturacionNegocio{

    @Override
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException {
        return factura;
    }
    
}
