package agendarCita;

import dtos.CitaDTO;

/**
 * Interfaz que define los métodos para el registro y la consulta de citas.
 * 
 * Proporciona métodos para registrar una nueva cita y consultar la disponibilidad de citas.
 * 
 */
public interface IAgendarCita {
    
    /**
     * Método para registrar una nueva cita.
     * 
     * @param nuevaCita objeto de tipo CitaDTO que contiene la información de la nueva cita.
     * @return un objeto de tipo CitaDTO que representa la cita registrada.
     */
    public CitaDTO registrarCita(CitaDTO nuevaCita);
    
    /**
     * Método para consultar la disponibilidad de una cita.
     * 
     * Este método consulta si hay disponibilidad para una cita en la fecha y hora especificadas.
     * 
     * @param nuevaCita objeto de tipo CitaDTO que contiene la información de la cita a consultar.
     * @return un objeto de tipo CitaDTO que representa la cita disponible o null si no hay disponibilidad.
     */
    public CitaDTO consultarDisponibilidadCita(CitaDTO nuevaCita);
    
}
