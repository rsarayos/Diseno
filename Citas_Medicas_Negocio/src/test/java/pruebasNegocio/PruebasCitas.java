package pruebasNegocio;

import agendarCita.AgendarCita;
import agendarCita.IAgendarCita;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import java.util.GregorianCalendar;

/**
 *
 * @author alex_
 */
public class PruebasCitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IAgendarCita agendar = new AgendarCita();
        
        CitaDTO citaNueva = new CitaDTO(
                new GregorianCalendar(2024, 3, 15, 16, 0), 
                new MedicoDTO("12345678"), 
                new PacienteDTO(1L), 
                "Cita chequeo periodico", 
                Boolean.TRUE);
        
        
//        agendar.registrarCita(citaNueva);
        
        CitaDTO citaDispo = agendar.consultarDisponibilidadCita(citaNueva);
        
        System.out.println(citaDispo);
        
        
        
    }
    
}
