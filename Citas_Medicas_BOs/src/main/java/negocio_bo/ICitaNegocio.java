package negocio_bo;

import dtos.CitaDTO;
import negocio_excepciones.NegocioException;

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
    
}
