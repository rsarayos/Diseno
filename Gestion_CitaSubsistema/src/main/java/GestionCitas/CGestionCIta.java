/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionCitas;
import BOs.ICitaNegocio;
import BOs.CitaNegocio;
import dtos.CitaDTO;
import excepciones.NegocioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase control del subsistema que se conecta con el BO
 * @author JESUS
 */
public class CGestionCIta {
    //Variables
    private final ICitaNegocio citaBO;
    static final Logger logger = Logger.getLogger(CGestionCIta.class.getName());
    
    /**
     * Constructor que inicializa el objeto con la clase BO
     */
    public CGestionCIta(){
        citaBO=new CitaNegocio();
    }
    
    
    /**
     * Obtiene una lista de citas basándose en los criterios especificados en el objeto CitaDTO.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios, o null en caso de error.
     */
    protected List<CitaDTO> obtenerCitas(CitaDTO cita){
        List<CitaDTO> citas = null;
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
    protected List<CitaDTO> obtenerCitaFecha(CitaDTO cita){
        List<CitaDTO> citas = null;
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
     * @param cita Objeto CitaDTO que contiene el nombre del paciente como criterio de búsqueda.
     * @return Lista de CitaDTO que coinciden con el nombre especificado, o null en caso de error.
     */
    protected List<CitaDTO> obtenerCitaNombre(CitaDTO cita){
        List<CitaDTO> citas = null;
        try {
            citas = citaBO.consultarPorNombre(cita);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por nombre");
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
    protected List<CitaDTO> obtenerCitaHora(CitaDTO cita){
        List<CitaDTO> citas = null;
        try {
            citas = citaBO.consultarPorHora(cita);
        } catch (NegocioException e) {
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
            logger.log(Level.SEVERE, "Error al cancelar cita");
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
            logger.log(Level.SEVERE, "Error al reasignar cita");
        }
        return citaR;
    }
    
    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * Maneja internamente las excepciones relacionadas con la lógica de negocio.
     *
     * @param cita CitaDTO que contiene la fecha a verificar.
     * @return CitaDTO con el resultado de la verificación, o null en caso de error.
     */
    protected CitaDTO verificarCita(CitaDTO cita){
        CitaDTO citaV = null;
        try {
            citaV = citaBO.verificarFecha(cita);
        } catch (NegocioException e) {
            logger.log(Level.SEVERE, "Error al verificar");
        }
        return citaV;
    }

    /**
     * Metodo de inserccion para pruebas
     * Maneja internamente cualquier tipo de excepción que pueda surgir durante su ejecución.
     */
    protected void insertarMoco(){
        try {
            citaBO.insertarMoco();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al insertar");
        }
    }
    
}
