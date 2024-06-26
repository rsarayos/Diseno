package objetosNegocio;

import dtos.CitaConPacienteDTO;
import dtos.CitaDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;

/**
 * Interfaz que define los métodos para la lógica de negocio relacionada con las citas médicas.
 * 
 * Esta interfaz proporciona métodos para la gestión de citas médicas, como agendar una cita y consultar la disponibilidad de citas.
 * Los métodos definidos en esta interfaz representan la capa de lógica de negocio para operaciones relacionadas con citas médicas.
 * 
 */
public interface ICitaNegocio {
    
    /**
     * Agendar una cita médica.
     * 
     * @param cita El objeto de tipo CitaDTO que representa la cita médica a agendar.
     * @return Un objeto de tipo CitaDTO que representa la cita médica agendada.
     * @throws NegocioException Si ocurre un error durante la operación de agendamiento de la cita.
     */
    public CitaDTO agendarCita(CitaDTO cita) throws NegocioException;
    
    /**
     * Consultar la disponibilidad de citas médicas.
     * 
     * @param cita El objeto de tipo CitaDTO que representa la cita médica para la cual se desea consultar la disponibilidad.
     * @return Un objeto de tipo CitaDTO que representa la disponibilidad de la cita médica.
     * @throws NegocioException Si ocurre un error durante la operación de consulta de disponibilidad de citas.
     */
    public CitaDTO consultarDisponibilidad(CitaDTO cita) throws NegocioException;
    
    /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitaConPacienteDTO> obtenerCitas(CitaDTO cita) throws NegocioException;
    
    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitaConPacienteDTO> consultarPorFecha(CitaDTO cita) throws NegocioException;

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cedula Cedula del medico
     * @param nombrePaciente Nombre del paciente
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitaConPacienteDTO> consultarPorNombre(String cedula, String nombrePaciente) throws NegocioException;

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitaConPacienteDTO> consultarPorHora(CitaDTO cita) throws NegocioException;

    /**
     * Cancela una cita específica.
     * 
     * @param cita Objeto CitaDTO que representa la cita a cancelar.
     * @return CitaDTO actualizada como cancelada.
     * @throws NegocioException Si ocurre un error durante la operación de cancelación.
     */
    public CitaDTO cancelarCita(CitaDTO cita) throws NegocioException;

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasigna CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO que contiene los nuevos detalles de la cita.
     * @return CitaDTO actualizada con la nueva información.
     * @throws NegocioException Si ocurre un error durante el proceso de reasignación.
     */
    public CitaDTO reasginarCita(CitaDTO citaReasigna, CitaDTO nueva) throws NegocioException;
    
}
