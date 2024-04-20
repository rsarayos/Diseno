package negocio_bo;

import dtos.CitaDTO;
import negocio_excepciones.NegocioException;

/**
 *
 * @author alex_
 */
public interface ICitaNegocio {
    
    public CitaDTO agendarCita(CitaDTO cita) throws NegocioException;
    public CitaDTO consultarDisponibilidad(CitaDTO cita) throws NegocioException;
    
}
