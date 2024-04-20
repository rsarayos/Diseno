package convertidores;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Medico y MedicoDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de Medico y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo Medico a MedicoDTO y viceversa.
 * 
 */
public class ConvertidorMedico {

    /**
     * Constructor predeterminado de ConvertidorMedico.
     */
    public ConvertidorMedico() {
        
    }
    
    /**
     * Convierte un objeto de tipo MedicoDTO a un objeto de tipo Medico.
     * 
     * @param m El objeto de tipo MedicoDTO que se va a convertir.
     * @return Un objeto de tipo Medico resultante de la conversión.
     */
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
    
    /**
     * Convierte un objeto de tipo Medico a un objeto de tipo MedicoDTO.
     * 
     * @param m El objeto de tipo Medico que se va a convertir.
     * @return Un objeto de tipo MedicoDTO resultante de la conversión.
     */
    public MedicoDTO convertidorEntidadaADTO(Medico m) {
        if (m != null) {

            ConvertidorCita convCita = new ConvertidorCita();

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
        } else {
            return null;
        }
    }
    
}
