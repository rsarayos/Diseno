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
    
    /**
     * Método para consultar si un telefono se encuentra previamente registrado en un paciente.
     * 
     * @param telefono Telefono a buscar en el sistema.
     * @return El paciente encontrado, o null si no se encontro ningun paciente.
     */
    public PacienteDTO consultarTelefonoRegistrado(String telefono);
    
}
