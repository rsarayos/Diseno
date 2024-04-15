package agendarCita;

import dtos.CitaDTO;

/**
 *
 * @author alex_
 */
public interface IAgendarCita {
    
    public CitaDTO registrarCita(CitaDTO nuevaCita);
    public CitaDTO consultarDisponibilidadCita(CitaDTO nuevaCita);
    
}
