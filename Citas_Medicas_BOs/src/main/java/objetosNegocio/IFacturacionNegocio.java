package objetosNegocio;

import dtos.FacturaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import excepcionesNegocio.NegocioException;

/**
 *
 * @author alex_
 */
public interface IFacturacionNegocio {
    
    public FacturaDTO registrarFactura(FacturaDTO factura) throws NegocioException;
    public MedicoDTO registrarDFMedico(MedicoDTO medico) throws NegocioException;
    public PacienteDTO registrarDFPaciente(PacienteDTO paciente) throws NegocioException;
    
}
