package consultarPacientes;

import dtos.PacienteDTO;
import java.util.List;

/**
 *
 * @author alex_
 */
public interface IConsultarPaciente {
    
    public List<PacienteDTO> consultarPacientes();
    
}
