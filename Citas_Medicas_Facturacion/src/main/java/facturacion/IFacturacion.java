package facturacion;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

/**
 *
 * @author alex_
 */
public interface IFacturacion {
    
    public FacturaDTO facturar(FacturaDTO factura);
    public MedicoDTO registrarDatosFiscalesMedico(MedicoDTO medico);
    public PacienteDTO registrarDatosFiscalesPaciente(PacienteDTO paciente);
    
}
