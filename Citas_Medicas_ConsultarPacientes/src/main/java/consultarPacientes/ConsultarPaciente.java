package consultarPacientes;

import dtos.PacienteDTO;
import java.util.List;

/**
 *
 * @author alex_
 */
public class ConsultarPaciente implements IConsultarPaciente{
    
    private final ConsultarPacienteCO control;

    public ConsultarPaciente() {
        control = new ConsultarPacienteCO();
    }

    @Override
    public List<PacienteDTO> consultarPacientes() {

        return control.consultarPacientes();
        
    }
    
}
