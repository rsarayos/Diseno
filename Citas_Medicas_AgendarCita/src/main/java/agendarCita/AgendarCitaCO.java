package agendarCita;

import dtos.CitaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_bo.CitaNegocio;
import negocio_bo.ICitaNegocio;
import negocio_excepciones.NegocioException;

/**
 *
 * @author alex_
 */
public class AgendarCitaCO {
    
    private final ICitaNegocio citaBO;
    static final Logger logger = Logger.getLogger(AgendarCitaCO.class.getName());

    public AgendarCitaCO() {
        citaBO = new CitaNegocio();
    }    
    
    protected CitaDTO registrarCita(CitaDTO nuevaCita) {

        CitaDTO cita = null;

        try {
            cita = citaBO.agendarCita(nuevaCita);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error al registrar la cita");
        }

        return cita;
    }
    
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
