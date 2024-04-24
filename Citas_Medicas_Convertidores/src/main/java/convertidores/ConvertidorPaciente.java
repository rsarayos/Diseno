package convertidores;

import entidades.Cita;
import entidades.Paciente;
import dtos.CitaDTO;
import dtos.PacienteDTO;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Paciente y PacienteDTO.
 * 
 * Esta clase se utiliza para realizar la conversión entre entidades de Paciente y sus respectivos DTO (Data Transfer Objects).
 * Los métodos en esta clase permiten convertir objetos de tipo Paciente a PacienteDTO y viceversa.
 * 
 */
public class ConvertidorPaciente {

    /**
     * Constructor predeterminado de ConvertidorPaciente.
     */
    public ConvertidorPaciente() {
        
    }

    /**
     * Convierte un objeto de tipo PacienteDTO a un objeto de tipo Paciente.
     * 
     * @param p El objeto de tipo PacienteDTO que se va a convertir.
     * @return Un objeto de tipo Paciente resultante de la conversión.
     */
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
    
    /**
     * Convierte un objeto de tipo Paciente a un objeto de tipo PacienteDTO.
     * 
     * @param p El objeto de tipo Paciente que se va a convertir.
     * @return Un objeto de tipo PacienteDTO resultante de la conversión.
     */
    public PacienteDTO convertidorEntidadaADTO(Paciente p) {
        if (p != null) {
            ConvertidorCita convCita = new ConvertidorCita();

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
        } else {
            return null;
        }

    }

}
