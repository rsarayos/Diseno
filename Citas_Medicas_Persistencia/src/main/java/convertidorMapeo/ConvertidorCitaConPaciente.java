package convertidorMapeo;

import entidades.CitaConPaciente;
import entidadesMapeo.CitaConPacienteMapeo;
import org.bson.types.ObjectId;

/**
 *
 * @author alex_
 */
public class ConvertidorCitaConPaciente {
    
    private ConvertidorPaciente conv;

    public ConvertidorCitaConPaciente() {
        this.conv = new ConvertidorPaciente();
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo CitaMapeo
     */
    public CitaConPacienteMapeo convertirEntidadAMapeo(CitaConPaciente cita){
        
        ObjectId idPac = new ObjectId(cita.getId());
        
        return new CitaConPacienteMapeo(
                idPac, 
                cita.getFechaHora(), 
                cita.getCedulaProfesional(), 
                conv.convertirEntidadAMapeo(cita.getPaciente()), 
                cita.getObservacion(), 
                cita.getEstado());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo Paciente
     */
    public CitaConPaciente convertirMapeoAEntidad(CitaConPacienteMapeo cita) {
        if (cita != null) {
            String idCit = cita.getId().toHexString();

            return new CitaConPaciente(
                    idCit,
                    cita.getFechaHora(),
                    cita.getCedulaProfesional(),
                    conv.convertirMapeoAEntidad(cita.getPaciente()),
                    cita.getObservacion(),
                    cita.getEstado());
        } else {
            return null;
        }
    }
    
    
}
