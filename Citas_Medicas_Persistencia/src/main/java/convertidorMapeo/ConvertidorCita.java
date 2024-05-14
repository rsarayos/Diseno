package convertidorMapeo;

import entidades.Cita;
import entidadesMapeo.CitaMapeo;

/**
 * Clase auxiliar para convertir objetos de tipo Cita y CitaMapeo
 */
public class ConvertidorCita {
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo CitaMapeo
     */
    protected CitaMapeo convertirEntidadAMapeo(Cita cita){
        
        return new CitaMapeo(
                cita.getFechaHora(),
                cita.getCedulaProfesional(),
                cita.getIdPaciente(),
                cita.getObservacion(),
                cita.getEstado());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo Paciente
     */
    protected Cita convertirEntidadAMapeo(CitaMapeo cita){
        
        return new Cita(
                cita.getFechaHora(),
                cita.getCedulaProfesional(),
                cita.getIdPaciente(),
                cita.getObservacion(),
                cita.getEstado());
    }
    
}
