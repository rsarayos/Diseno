package agendarCita;

import dtos.CitaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.CitaNegocio;
import objetosNegocio.ICitaNegocio;
import excepcionesNegocio.NegocioException;

/**
 * Clase de control que encapsula la lógica para registrar y consultar citas.
 * 
 * Esta clase se encarga de interactuar con el negocio relacionado con las citas
 * mediante el objeto de la interfaz ICitaNegocio.
 * 
 */
public class CAgendarCita {
    
    /** Objeto de negocio que realiza las operaciones relacionadas con las citas. */
    private final ICitaNegocio citaBO;
    
    /** Objeto Logger para la gestión de logs. */
    static final Logger logger = Logger.getLogger(CAgendarCita.class.getName());

    /**
     * Constructor de la clase AgendarCitaCO.
     * 
     * Se inicializa el objeto de negocio ICitaNegocio.
     */
    public CAgendarCita() {
        citaBO = new CitaNegocio();
    }    
    
    /**
     * Método para registrar una nueva cita.
     * 
     * @param nuevaCita objeto de tipo CitaDTO que contiene la información de la nueva cita.
     * @return un objeto de tipo CitaDTO que representa la cita registrada.
     */
    protected CitaDTO registrarCita(CitaDTO nuevaCita) {

        CitaDTO cita = null;

        try {
            cita = citaBO.agendarCita(nuevaCita);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error al registrar la cita");
        }

        return cita;
    }
    
    /**
     * Método para consultar la disponibilidad de una cita.
     * 
     * Este método consulta si hay disponibilidad para una cita en la fecha y hora especificadas.
     * 
     * @param nuevaCita objeto de tipo CitaDTO que contiene la información de la cita a consultar.
     * @return un objeto de tipo CitaDTO que representa la cita disponible o null si no hay disponibilidad.
     */
    protected CitaDTO consultarDisponibilidadCita(CitaDTO nuevaCita) {
        
        CitaDTO cita = null;

        try {
            cita = citaBO.consultarDisponibilidad(nuevaCita);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error al registrar la cita");
        }

        return cita;
    }
    
    
}
