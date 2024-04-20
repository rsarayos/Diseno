package negocio_bo;

import dtos.PacienteDTO;
import java.util.List;
import negocio_excepciones.NegocioException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los pacientes.
 * 
 * Define métodos para registrar nuevos pacientes y obtener la lista de pacientes.
 * 
 */
public interface IPacienteNegocio {
    
    /**
     * Registra un nuevo paciente en el sistema.
     * 
     * @param paciente El paciente a registrar.
     * @return El paciente registrado.
     * @throws NegocioException Si ocurre un error durante el registro del paciente.
     */
    public PacienteDTO registrarPaciente(PacienteDTO paciente) throws NegocioException;
    
    /**
     * Obtiene la lista de todos los pacientes registrados en el sistema.
     * 
     * @return La lista de pacientes registrados.
     * @throws NegocioException Si ocurre un error al obtener la lista de pacientes.
     */
    public List<PacienteDTO> obtenerPacientes() throws NegocioException;
    
}
