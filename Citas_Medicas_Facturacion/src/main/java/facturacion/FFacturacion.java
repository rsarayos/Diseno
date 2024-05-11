package facturacion;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

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

    @Override
    public MedicoDTO registrarDatosFiscalesMedico(MedicoDTO medico) {
        
        return control.registrarDFMedico(medico);
        
    }

    @Override
    public PacienteDTO registrarDatosFiscalesPaciente(PacienteDTO paciente) {
        
        return control.registrarDFPaciente(paciente);
        
    }
    
}
