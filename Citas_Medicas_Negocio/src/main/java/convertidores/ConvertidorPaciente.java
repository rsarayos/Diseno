package convertidores;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Paciente;
import dtos.CitaDTO;
import dtos.PacienteDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alex_
 */
public class ConvertidorPaciente {
    
    private ConvertidorCita convCita;

    public ConvertidorPaciente() {
        this.convCita = new ConvertidorCita();
        
    }

    public Paciente convertidorDTOAEntidad(PacienteDTO p) {
        
        return new Paciente(
                p.getNombres(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getTelefono(),
                p.getCorreo()
        );
        
    }
    
    public PacienteDTO convertidorEntidadaADTOSinCitas(Paciente p) {
        
        return new PacienteDTO(
                p.getId(),
                p.getNombre(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getTelefono(),
                p.getCorreo()
        );
        
    }
    
    public PacienteDTO convertidorEntidadaADTOConCitas(Paciente p) {
        
        List<CitaDTO> citas = new LinkedList<>();
        if (p.getCitas() != null) {
            for (Cita c : p.getCitas()) {
                citas.add(convCita.convertidorEntidadaADTO(c));
            }
        }
        
        return new PacienteDTO(
                p.getId(),
                p.getNombre(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getFechaNacimiento(),
                p.getEdad(),
                p.getTelefono(),
                p.getCorreo(),
                citas
        );
        
    }

}
