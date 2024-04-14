package agendarCita;

import Entidades.Cita;
import Entidades.Paciente;
import Persistencia.CitasDAO;
import dtos.CitaDTO;

/**
 *
 * @author alex_
 */
public class AgendarCita implements IAgendarCita{

    private CitasDAO citas;

    public AgendarCita() {
        citas = new CitasDAO();
    }
    
    @Override
    public boolean registrarCita(CitaDTO nuevaCita) {
        
        Paciente paciente = new Paciente(
                nuevaCita.getPaciente().getNombres(), 
                nuevaCita.getPaciente().getApellidoPaterno(), 
                nuevaCita.getPaciente().getApellidoMaterno(), 
                nuevaCita.getPaciente().getTelefono(), 
                nuevaCita.getPaciente().getCorreo());
        
        Cita cita = new Cita(nuevaCita.getFecha(), paciente, nuevaCita.getObservaciones());
        
        return citas.agregarCita(cita);
    }
    
}
