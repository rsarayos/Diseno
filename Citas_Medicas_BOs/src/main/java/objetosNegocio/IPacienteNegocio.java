package objetosNegocio;

import dtos.PacienteDTO;
import java.util.List;
import excepcionesNegocio.NegocioException;

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
     * Busca un paciente en el sistema que tenga el telefono a buscar.
     * 
     * @param telefono El telefono del paciente a buscar.
     * @return El paciente encontrado, o null si no se encontro coincidencia.
     * @throws NegocioException Si ocurre un error durante la busqueda del paciente.
     */
    public PacienteDTO buscarPacienteTelefono(String telefono) throws NegocioException;
    
    /**
     * Obtiene la lista de todos los pacientes registrados en el sistema.
     * 
     * @return La lista de pacientes registrados.
     * @throws NegocioException Si ocurre un error al obtener la lista de pacientes.
     */
    public List<PacienteDTO> obtenerPacientes() throws NegocioException;
    
}
