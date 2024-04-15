package convertidores;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alex_
 */
public class ConvertidorMedico {
    
    private ConvertidorCita convCita;

    public ConvertidorMedico() {
        this.convCita = new ConvertidorCita();
        
    }
    
    public Medico convertidorDTOAEntidad(MedicoDTO m) {
        
        return new Medico(
                m.getCedulaProfesional(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getFechaNacimiento(),
                m.getEspecialidad(),
                m.getRfc(),
                m.getTelefono(),
                m.getCorreo(),
                m.getContrasenia()
        );
        
    }
    
    public MedicoDTO convertidorEntidadaADTOSinCitas(Medico m) {
        
        return new MedicoDTO(
                m.getCedulaProfesional(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getFechaNacimiento(),
                m.getEspecialidad(),
                m.getRfc(),
                m.getTelefono(),
                m.getCorreo(),
                m.getContrasenia()
        );
        
    }
    
    public MedicoDTO convertidorEntidadaADTOConCitas(Medico m) {
        
        List<CitaDTO> citas = new LinkedList<>();
        if (m.getCitas() != null) {
            for (Cita c : m.getCitas()) {
                citas.add(convCita.convertidorEntidadaADTO(c));
            }
        }
        
        return new MedicoDTO(
                m.getCedulaProfesional(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getFechaNacimiento(),
                m.getEspecialidad(),
                m.getRfc(),
                m.getTelefono(),
                m.getCorreo(),
                m.getContrasenia(),
                citas
        );
        
    }
    
}
