package convertidorMapeo;

import entidades.Paciente;
import entidadesMapeo.PacienteMapeo;
import org.bson.types.ObjectId;

/**
 * Clase auxiliar para convertir objetos de tipo Paciente y PacienteMapeo
 */
public class ConvertidorPaciente {
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param paciente entidad a convertir
     * @return un objeto de tipo PacienteMapeo
     */
    public PacienteMapeo convertirEntidadAMapeo(Paciente paciente) {
        if (paciente.getId() != null) {
            if (paciente.getDatosFiscales() != null) {
                
                ObjectId idPac = new ObjectId(paciente.getId());
                
                return new PacienteMapeo(
                        idPac,
                        paciente.getNombre(),
                        paciente.getApellidoPaterno(),
                        paciente.getApellidoMaterno(),
                        paciente.getFechaNacimiento(),
                        paciente.getTelefono(),
                        paciente.getCorreo(),
                        paciente.getDatosFiscales());
            }
        }
        return new PacienteMapeo(
                paciente.getNombre(),
                paciente.getApellidoPaterno(),
                paciente.getApellidoMaterno(),
                paciente.getFechaNacimiento(),
                paciente.getTelefono(),
                paciente.getCorreo());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param paciente entidad a convertir
     * @return un objeto de tipo Paciente
     */
    public Paciente convertirMapeoAEntidad(PacienteMapeo paciente) {
        if (paciente != null) {
            String idPac = paciente.getId().toHexString();

            if (paciente.getDatosFiscales() != null) {
                return new Paciente(
                        idPac,
                        paciente.getNombre(),
                        paciente.getApellidoPaterno(),
                        paciente.getApellidoMaterno(),
                        paciente.getFechaNacimiento(),
                        paciente.getTelefono(),
                        paciente.getCorreo(),
                        paciente.getDatosFiscales());
            } else {
                return new Paciente(
                        idPac,
                        paciente.getNombre(),
                        paciente.getApellidoPaterno(),
                        paciente.getApellidoMaterno(),
                        paciente.getFechaNacimiento(),
                        paciente.getEdad(),
                        paciente.getTelefono(),
                        paciente.getCorreo());
            }
        } else {
            return null;
        }
    }

}
