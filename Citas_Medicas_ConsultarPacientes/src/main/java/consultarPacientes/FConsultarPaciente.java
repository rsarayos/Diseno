package consultarPacientes;

import dtos.PacienteDTO;
import java.util.List;

/**
 * Clase que implementa la interfaz IConsultarPaciente para consultar pacientes.
 * 
 * Esta clase delega la consulta de pacientes al controlador ConsultarPacienteCO.
 * 
 */
public class FConsultarPaciente implements IConsultarPaciente{
    
    /** Objeto de la clase CConsultarPaciente para realizar las operaciones de consulta de pacientes. */
    private final CConsultarPaciente control;

    /**
     * Constructor de la clase ConsultarPaciente.
     */
    public FConsultarPaciente() {
        control = new CConsultarPaciente();
    }

    @Override
    public List<PacienteDTO> consultarPacientes() {

        return control.consultarPacientes();
        
    }

    @Override
    public PacienteDTO consultarTelefonoRegistrado(String telefono) {
        
        return control.verificarTelefonoExistente(telefono);
        
    }
    
}
