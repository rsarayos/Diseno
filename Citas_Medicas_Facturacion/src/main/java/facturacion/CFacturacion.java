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
 * Clase que actúa como controlador para realizar operaciones relacionadas con la facturación.
 */
public class CFacturacion {
    
    /** Instancia para interactuar con la capa de negocio de facturación. */
    private IFacturacionNegocio negocio;
    
    /** Instancia para generar la impresión de la factura. */
    private GenerarFacturaImpresa impresion;
    
    /** Instancia para realizar el timbrado de la factura. */
    private TimbrarFactura timbrado;

    /**
     * Constructor de la clase CFacturacion que inicializa las instancias necesarias.
     */
    public CFacturacion() {
        this.negocio = new FacturacionNegocio();
        this.impresion = new GenerarFacturaImpresa();
        this.timbrado = new TimbrarFactura();
    }
    
    /**
     * Realiza el proceso de facturación.
     *
     * @param factura La factura a ser procesada.
     * @return La factura procesada.
     */
    protected FacturaDTO facturar(FacturaDTO factura){
        
        
        FacturaDTO facturaTimbrada = timbrado.timbrarFactura(factura);
        
        try {
            negocio.registrarFactura(factura);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        impresion.generarImpresion(facturaTimbrada);
        
        return facturaTimbrada;
    }
    
    /**
     * Registra datos fiscales de un médico en el sistema.
     *
     * @param medico El médico con datos fiscales a ser registrados.
     * @return El médico con datos fiscales registrados.
     */
    protected MedicoDTO registrarDFMedico(MedicoDTO medico){
        try {
            return negocio.registrarDFMedico(medico);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Registra datos fiscales de un paciente en el sistema.
     *
     * @param paciente El paciente con datos fiscales a ser registrados.
     * @return El paciente con datos fiscales registrados.
     */
    protected PacienteDTO registrarDFPaciente(PacienteDTO paciente){
        try {
            return negocio.registrarDFPaciente(paciente);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Busca un paciente dentro del sistema con el rfc especificado.
     *
     * @param rfc El rfc del paciente a buscar.
     * @return El paciente con el rfc especificado, o null si no se encontro coincidencia.
     */
    protected PacienteDTO verificarRFCExistente(String rfc){
        
        try {
            return negocio.obtenerPacienteRFC(rfc);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    protected Integer obtenerFolioFactura(MedicoDTO medico) {

        try {
            return negocio.obtenerFolioNuevo(medico);
        } catch (NegocioException ex) {
            Logger.getLogger(CFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
