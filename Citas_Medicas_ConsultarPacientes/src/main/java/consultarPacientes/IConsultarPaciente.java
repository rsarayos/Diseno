package consultarPacientes;

import dtos.PacienteDTO;
import java.util.List;

/**
 * Interfaz para consultar pacientes.
 * 
 * Define un método para obtener una lista de objetos PacienteDTO que representan los pacientes registrados.
 * 
 */
public interface IConsultarPaciente {
    
    /**
     * Método para consultar la lista de pacientes.
     * 
     * @return una lista de objetos PacienteDTO que representan los pacientes registrados.
     */
    public List<PacienteDTO> consultarPacientes();
    
}
