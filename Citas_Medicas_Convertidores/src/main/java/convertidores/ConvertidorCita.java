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
        
        ObjectId idPac = new ObjectId(c.getIdPaciente());
        
        return new Cita(
                c.getFechaHora(), 
                c.getCedulaMedico(), 
                idPac, 
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

             String id = c.getIdPaciente().toHexString();
            
            return new CitaDTO(
                    c.getFechaHora(),
                    c.getCedulaProfesional(),
                    id,
                    c.getObservacion(),
                    c.getEstado()
            );
        }

        return null;
    }
    
}
