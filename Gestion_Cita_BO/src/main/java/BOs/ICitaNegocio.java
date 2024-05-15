/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;
import excepciones.NegocioException;
import dtos.CitaDTO;
import dtos.CitasConPacienteDTO;
import dtos.PacienteDTO;
import java.util.List;

/**
 * Clase interfaz para citaNegocio
 * @author JESUS
 */
public interface ICitaNegocio {
    
    /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitasConPacienteDTO> obtenerCitas(CitaDTO cita) throws NegocioException;

    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitasConPacienteDTO> consultarPorFecha(CitaDTO cita) throws NegocioException;

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cita Objeto CitaDTO que contiene el nombre del paciente como criterio de búsqueda.
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitasConPacienteDTO> consultarPorNombre(CitaDTO cita,PacienteDTO nombre) throws NegocioException;

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<CitasConPacienteDTO> consultarPorHora(CitaDTO cita) throws NegocioException;

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

    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param cita CitaDTO que contiene la fecha a verificar.
     * @return CitaDTO con el resultado de la verificación.
     * @throws NegocioException Si ocurre un error al verificar la fecha.
     */
    public CitaDTO verificarFecha(CitaDTO cita) throws NegocioException;

    /**
     * Método inserccion para pruebas
     * 
     * @throws NegocioException Si se define que debe simular un error de negocio.
     */
    public void insertarMoco() throws NegocioException;
}
