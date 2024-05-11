package facturacion;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import excepcionesNegocio.NegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    protected MedicoDTO registrarDFMedico(MedicoDTO medico){
        try {
            return persistencia.registrarDFMedico(medico);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    protected PacienteDTO registrarDFPaciente(PacienteDTO paciente){
        try {
            return persistencia.registrarDFPaciente(paciente);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
