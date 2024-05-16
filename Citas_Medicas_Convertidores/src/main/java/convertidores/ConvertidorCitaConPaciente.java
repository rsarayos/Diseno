package convertidores;

import dtos.CitaConPacienteDTO;
import dtos.PacienteDTO;
import entidades.CitaConPaciente;
import entidades.Paciente;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo CitaConPaciente y CitaConPacienteDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de CitaConPaciente y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo CitaConPaciente a CitaConPacienteDTO y viceversa.
 * 
 */
public class ConvertidorCitaConPaciente {
    
    private ConvertidorPaciente conv;
    
    /**
     * Constructor predeterminado de ConvertidorCita.
     */
    public ConvertidorCitaConPaciente() {
        this.conv = new ConvertidorPaciente();
    }
    
    /**
     * Convierte un objeto de tipo CitaConPacienteDTO a un objeto de tipo CitaConPaciente.
     * 
     * @param c El objeto de tipo CitaConPacienteDTO que se va a convertir.
     * @return Un objeto de tipo CitaConPaciente resultante de la conversión.
     */
    public CitaConPaciente DTOAEntidad(CitaConPacienteDTO c) {
        
        Paciente paciente = conv.DTOAEntidadCompleto(c.getPaciente());
        
        if (c.getId() != null) {
            CitaConPaciente cita = new CitaConPaciente(
                    c.getFechaHora(),
                    c.getCedulaMedico(),
                    paciente,
                    c.getObservaciones(),
                    c.getEstado()
            );
            cita.setId(c.getId());

            return cita;

        }
        
        return new CitaConPaciente(
                c.getFechaHora(), 
                c.getCedulaMedico(), 
                paciente, 
                c.getObservaciones(), 
                c.getEstado()
        );
        
    }
    
    /**
     * Convierte un objeto de tipo CitaConPaciente a un objeto de tipo CitaConPacienteDTO.
     * 
     * @param c El objeto de tipo CitaConPaciente que se va a convertir.
     * @return Un objeto de tipo CitaConPacienteDTO resultante de la conversión.
     */
    public CitaConPacienteDTO EntidadaADTO(CitaConPaciente c) {
        if (c != null) {
            PacienteDTO paciente = conv.EntidadaADTO(c.getPaciente());
            
            return new CitaConPacienteDTO(
                    c.getId(),
                    c.getFechaHora(),
                    c.getCedulaProfesional(),
                    paciente,
                    c.getObservacion(),
                    c.getEstado()
            );
        }
        return null;
    }
    
}
