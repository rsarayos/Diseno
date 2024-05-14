/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionCitas;

import dtos.CitaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Clase interfaz para metodo del subsistema del gestion de citas
 * @author JESUS
 */
public interface IGestionCita {
    
     /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     */
    public List<CitaDTO> obtenerCitas(CitaDTO cita);

    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     */
    public List<CitaDTO> consultarPorFecha(CitaDTO cita);

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cita Objeto CitaDTO que contiene el nombre del paciente como criterio de búsqueda.
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     */
    public List<CitaDTO> consultarPorNombre(CitaDTO cita);

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     */
    public List<CitaDTO> consultarPorHora(CitaDTO cita);

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
     * @param citaReasgina CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO que contiene los nuevos detalles de la cita.
     * @return CitaDTO actualizada con la nueva información.
     */
    public CitaDTO reasginarCita(CitaDTO citaReasgina, CitaDTO nueva);

    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param cita CitaDTO que contiene la fecha a verificar.
     * @return CitaDTO con el resultado de la verificación.
     */
    public CitaDTO verificarFecha(CitaDTO cita);

    /**
     * Método de inserccion para pruebas
     */
    public void insertarMoco();
}
