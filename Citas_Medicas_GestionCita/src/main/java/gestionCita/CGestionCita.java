package gestionCita;

import dtos.CitaConPacienteDTO;
import dtos.CitaDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.CitaNegocio;
import objetosNegocio.ICitaNegocio;

/**
 * Clase control del subsistema que se conecta con el BO
 */
public class CGestionCita {
    
    private final ICitaNegocio citaBO;
    static final Logger logger = Logger.getLogger(CGestionCita.class.getName());
    
    /**
     * Constructor que inicializa el objeto con la clase BO
     */
    public CGestionCita(){
        this.citaBO = new CitaNegocio();
    }
    
    /**
     * Obtiene una lista de citas basándose en los criterios especificados en el objeto CitaDTO.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios, o null en caso de error.
     */
    protected List<CitaConPacienteDTO> obtenerCitas(CitaDTO cita){
        List<CitaConPacienteDTO> citas = null;
        try {
            citas = citaBO.obtenerCitas(cita);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al obtener citas");
        }
        return citas;
    }

    /**
     * Obtiene una lista de citas filtradas por fecha.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO para la fecha especificada, o null en caso de error.
     */
    protected List<CitaConPacienteDTO> obtenerCitaFecha(CitaDTO cita){
        List<CitaConPacienteDTO> citas = null;
        try {
            citas = citaBO.consultarPorFecha(cita);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por fecha");
        }
        return citas;
    }

    /**
     * Obtiene una lista de citas filtradas por nombre del paciente.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cedula Cedula del medico
     * @param nombrePaciente Nombre del paciente
     * @return Lista de CitaDTO que coinciden con el nombre especificado, o null en caso de error.
     */
    protected List<CitaConPacienteDTO> obtenerCitaNombre(String cedula, String nombrePaciente){
        List<CitaConPacienteDTO> citas = null;
        try {
            citas = citaBO.consultarPorNombre(cedula,nombrePaciente);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error al consultar por nombre");
        }
        return citas;
    }

    /**
     * Obtiene una lista de citas filtradas por hora específica.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cita Objeto CitaDTO que contiene la hora específica de interés.
     * @return Lista de CitaDTO programadas para esa hora, o null en caso de error.
     */
    protected List<CitaConPacienteDTO> obtenerCitaHora(CitaDTO cita){
        List<CitaConPacienteDTO> citas = null;
        try {
            citas = citaBO.consultarPorHora(cita);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error al obtener citas por hora");
        }
        return citas;
    }

    /**
     * Cancela una cita específica.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cita Objeto CitaDTO que representa la cita a cancelar.
     * @return CitaDTO actualizada como cancelada, o null en caso de error.
     */
    protected CitaDTO cancelarCita(CitaDTO cita){
        CitaDTO citaC = null;
        try {
            citaC = citaBO.cancelarCita(cita);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al cancelar la cita");
        }
        return citaC;
    }

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param citaReasigna CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO con los nuevos detalles de la cita.
     * @return CitaDTO reasignada, o null en caso de error.
     */
    protected CitaDTO reasignarCita(CitaDTO citaReasigna, CitaDTO nueva){
        CitaDTO citaR = null;
        try {
            citaR = citaBO.reasginarCita(citaReasigna, nueva);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al reasignar cita{0}", e);
        }
        return citaR;
    }
    
}
