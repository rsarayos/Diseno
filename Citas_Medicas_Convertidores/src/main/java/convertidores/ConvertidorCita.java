package convertidores;

import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import dtos.CitaDTO;
import dtos.MedicoDTO;
import dtos.PacienteDTO;
import org.bson.types.ObjectId;

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
    public Cita DTOAEntidad(CitaDTO c) {

        if (c.getId() != null) {
            Cita cita = new Cita(
                    c.getFechaHora(),
                    c.getCedulaMedico(),
                    c.getIdPaciente(),
                    c.getObservaciones(),
                    c.getEstado()
            );
            cita.setId(c.getId());

            return cita;

        }

        return new Cita(
                c.getFechaHora(),
                c.getCedulaMedico(),
                c.getIdPaciente(),
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
    public CitaDTO EntidadaADTO(Cita c) {

        if (c != null) {
            
            return new CitaDTO(
                    c.getId(),
                    c.getFechaHora(),
                    c.getCedulaProfesional(),
                    c.getIdPaciente(),
                    c.getObservacion(),
                    c.getEstado()
            );
        }

        return null;
    }
    
}
