package facturacion;

import dtos.FacturaDTO;

/**
 *
 * @author alex_
 */
public class FFacturacion implements IFacturacion{
    
    private CFacturacion control;

    public FFacturacion() {
        control = new CFacturacion();
    }

    @Override
    public FacturaDTO facturar(FacturaDTO factura) {
        
        return control.facturar(factura);
        
    }
    
}
