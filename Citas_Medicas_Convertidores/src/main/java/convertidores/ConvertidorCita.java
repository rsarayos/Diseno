package convertidores;

import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Cita y CitaDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de Cita y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo Cita a CitaDTO y viceversa.
 * 
 */
public class ConvertidorCita {
    
    /**
     * Constructor predeterminado de ConvertidorCita.
     */
    public ConvertidorCita() {
    }
    
    /**
     * Convierte un objeto de tipo CitaDTO a un objeto de tipo Cita.
     * 
     * @param c El objeto de tipo CitaDTO que se va a convertir.
     * @return Un objeto de tipo Cita resultante de la conversión.
     */
    public Cita convertidorDTOAEntidad(CitaDTO c) {
        
        Medico medico = new Medico(
                c.getMedico().getCedulaProfesional(), 
                c.getMedico().getNombre(), 
                c.getMedico().getApellidoPaterno(), 
                c.getMedico().getApellidoMaterno(), 
                c.getMedico().getFechaNacimiento(), 
                c.getMedico().getEspecialidad(), 
                c.getMedico().getRfc(), 
                c.getMedico().getTelefono(), 
                c.getMedico().getCorreo(), 
                c.getMedico().getContrasenia());
        
        Paciente paciente = new Paciente(
                c.getPaciente().getNombres(), 
                c.getPaciente().getApellidoPaterno(), 
                c.getPaciente().getApellidoMaterno(), 
                c.getPaciente().getFechaNacimiento(), 
                c.getPaciente().getTelefono(), 
                c.getPaciente().getCorreo());
        
        return new Cita(
                c.getFechaHora(), 
                medico, 
                paciente, 
                c.getObservaciones(), 
                c.getEstado()
        );
        
    }
    
    /**
     * Convierte un objeto de tipo Cita a un objeto de tipo CitaDTO.
     * 
     * @param c El objeto de tipo Cita que se va a convertir.
     * @return Un objeto de tipo CitaDTO resultante de la conversión.
     */
    public CitaDTO convertidorEntidadaADTO(Cita c) {
        
        MedicoDTO medico = new MedicoDTO(
                c.getMedico().getCedulaProfesional(), 
                c.getMedico().getNombre(), 
                c.getMedico().getApellidoPaterno(), 
                c.getMedico().getApellidoMaterno(), 
                c.getMedico().getFechaNacimiento(), 
                c.getMedico().getEspecialidad(), 
                c.getMedico().getRfc(), 
                c.getMedico().getTelefono(), 
                c.getMedico().getCorreo(), 
                c.getMedico().getContrasenia());
        
        PacienteDTO paciente = new PacienteDTO(
                c.getPaciente().getNombre(), 
                c.getPaciente().getApellidoPaterno(), 
                c.getPaciente().getApellidoMaterno(), 
                c.getPaciente().getFechaNacimiento(), 
                c.getPaciente().getTelefono(), 
                c.getPaciente().getCorreo());
        
        return new CitaDTO(
                c.getFechaHora(), 
                medico, 
                paciente, 
                c.getObservacion(), 
                c.getEstado()
        );
        
    }
    
}
