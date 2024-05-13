package facturacion;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

/**
 * Implementación de la interfaz IFacturacion que actúa como fachada para
 * delegar las operaciones de facturación a la clase CFacturacion.
 */
public class FFacturacion implements IFacturacion {

     /** Controlador para realizar las operaciones de facturación. */
    private CFacturacion control;

    /**
     * Constructor de la clase FFacturacion que inicializa el controlador de facturación.
     */
    public FFacturacion() {
        control = new CFacturacion();
    }

    @Override
    public FacturaDTO facturar(FacturaDTO factura) {
        
        return control.facturar(factura);
        
    }

    @Override
    public MedicoDTO registrarDatosFiscalesMedico(MedicoDTO medico) {
        
        return control.registrarDFMedico(medico);
        
    }

    @Override
    public PacienteDTO registrarDatosFiscalesPaciente(PacienteDTO paciente) {
        
        return control.registrarDFPaciente(paciente);
        
    }

    @Override
    public PacienteDTO buscarRFCExistente(String rfc) {
        
        return control.verificarRFCExistente(rfc);
        
    }

    @Override
    public Integer obtenerNuevoFolio(MedicoDTO medico) {
        
        return control.obtenerFolioFactura(medico);
        
    }
    
}
