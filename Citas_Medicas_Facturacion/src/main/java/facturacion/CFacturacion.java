package facturacion;

import dtos.FacturaDTO;
import objetosNegocio.FacturacionNegocio;
import objetosNegocio.IFacturacionNegocio;
import timbradofactura.TimbrarFactura;

/**
 *
 * @author alex_
 */
public class CFacturacion {
    
    private IFacturacionNegocio persistencia;
    private GenerarFacturaImpresa impresion;
    private TimbrarFactura timbrado;

    public CFacturacion() {
        this.persistencia = new FacturacionNegocio();
        this.impresion = new GenerarFacturaImpresa();
        this.timbrado = new TimbrarFactura();
    }
    
    protected FacturaDTO facturar(FacturaDTO factura){
        
        FacturaDTO facturaTimbrada = timbrado.timbrarFactura(factura);
        impresion.generarImpresion(facturaTimbrada);
        
        return facturaTimbrada;
    }
    
    
    
}
