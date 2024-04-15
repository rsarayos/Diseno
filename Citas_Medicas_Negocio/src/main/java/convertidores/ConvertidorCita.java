package convertidores;

import citas_medicas_entidades.Cita;
import dtos.CitaDTO;

/**
 *
 * @author alex_
 */
public class ConvertidorCita {
    
    private ConvertidorPaciente convPaciente;
    private ConvertidorMedico convMedico;

    public ConvertidorCita() {
        this.convPaciente = new ConvertidorPaciente();
        this.convMedico = new ConvertidorMedico();
    }
    
    public Cita convertidorDTOAEntidad(CitaDTO c) {
        
        return new Cita(
                c.getFechaHora(), 
                convMedico.convertidorDTOAEntidad(c.getMedico()), 
                convPaciente.convertidorDTOAEntidad(c.getPaciente()), 
                c.getObservaciones(), 
                c.getEstado()
        );
        
    }
    
    public CitaDTO convertidorEntidadaADTO(Cita c) {
        
        return new CitaDTO(
                c.getFechaHora(), 
                convMedico.convertidorEntidadaADTOSinCitas(c.getMedico()), 
                convPaciente.convertidorEntidadaADTOSinCitas(c.getPaciente()), 
                c.getObservacion(), 
                c.getEstado()
        );
        
    }
    
}
