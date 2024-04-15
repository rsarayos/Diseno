package convertidores;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import citas_medicas_entidades.Paciente;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;

/**
 *
 * @author alex_
 */
public class ConvertidorCita {
    
    public ConvertidorCita() {
    }
    
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
