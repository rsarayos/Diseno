package gestionCita;

import dtos.CitaConPacienteDTO;
import dtos.CitaDTO;
import java.util.List;

/**
 * Clase interfaz para metodo del subsistema del gestion de citas
 */
public interface IGestionCita {
    
    /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     */
    public List<CitaConPacienteDTO> obtenerCitas(CitaDTO cita);

    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     */
    public List<CitaConPacienteDTO> consultarPorFecha(CitaDTO cita);

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cedula Cedula del medico
     * @param nombrePaciente Nombre del paciente
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     */
    public List<CitaConPacienteDTO> consultarPorNombre(String cedula, String nombrePaciente);

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     */
    public List<CitaConPacienteDTO> consultarPorHora(CitaDTO cita);

    /**
     * Cancela una cita específica.
     * 
     * @param cita Objeto CitaDTO que representa la cita a cancelar.
     * @return CitaDTO actualizada como cancelada.
     */
    public CitaDTO cancelarCita(CitaDTO cita);

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasignar CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO que contiene los nuevos detalles de la cita.
     * @return CitaDTO actualizada con la nueva información.
     */
    public CitaDTO reasignarCita(CitaDTO citaReasignar, CitaDTO nueva);
    
}
