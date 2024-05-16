package convertidorMapeo;

import entidades.Cita;
import entidadesMapeo.CitaMapeo;
import org.bson.types.ObjectId;

/**
 * Clase auxiliar para convertir objetos de tipo Cita y CitaMapeo
 */
public class ConvertidorCita {
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo CitaMapeo
     */
    public CitaMapeo convertirEntidadAMapeo(Cita cita){
        
        ObjectId idPac = new ObjectId(cita.getIdPaciente());
        
        if (cita.getId() != null) {
            ObjectId idCit = new ObjectId(cita.getId());

            return new CitaMapeo(
                    idCit,
                    cita.getFechaHora(),
                    cita.getCedulaProfesional(),
                    idPac,
                    cita.getObservacion(),
                    cita.getEstado());
        }
        
        return new CitaMapeo(
                cita.getFechaHora(),
                cita.getCedulaProfesional(),
                idPac,
                cita.getObservacion(),
                cita.getEstado());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo Paciente
     */
    public Cita convertirMapeoAEntidad(CitaMapeo cita) {
        if (cita != null) {
            String idCit = cita.getId().toHexString();
            String idPac = cita.getIdPaciente().toHexString();

            return new Cita(
                    idCit,
                    cita.getFechaHora(),
                    cita.getCedulaProfesional(),
                    idPac,
                    cita.getObservacion(),
                    cita.getEstado());
        } else {
            return null;
        }
    }

}
