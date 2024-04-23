package consultarPacientes;

import citas_medicas_dao.PacienteDAOListas;
import dtos.PacienteDTO;
import java.util.List;

/**
 * Clase que implementa la interfaz IConsultarPaciente para consultar pacientes.
 * 
 * Esta clase delega la consulta de pacientes al controlador ConsultarPacienteCO.
 * 
 */
public class ConsultarPaciente implements IConsultarPaciente{
    
    /** Objeto de la clase ConsultarPacienteCO para realizar las operaciones de consulta de pacientes. */
    private final ConsultarPacienteCO control;

    /**
     * Constructor de la clase ConsultarPaciente.
     */
    public ConsultarPaciente() {
        control = new ConsultarPacienteCO();
    }

    public ConsultarPaciente(PacienteDAOListas pacienteDAO) {
        this.control = new ConsultarPacienteCO(pacienteDAO);
    }

    @Override
    public List<PacienteDTO> consultarPacientes() {

        return control.consultarPacientes();
        
    }
    
}
