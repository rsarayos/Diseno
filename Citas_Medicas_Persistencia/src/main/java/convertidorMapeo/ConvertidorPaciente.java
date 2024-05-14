package convertidorMapeo;

import entidades.Paciente;
import entidadesMapeo.PacienteMapeo;

/**
 * Clase auxiliar para convertir objetos de tipo Paciente y PacienteMapeo
 */
public class ConvertidorPaciente {
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param paciente entidad a convertir
     * @return un objeto de tipo PacienteMapeo
     */
    protected PacienteMapeo convertirEntidadAMapeo(Paciente paciente){
        
        if (paciente.getDatosFiscales() != null) {
        return new PacienteMapeo(
                paciente.getNombre(), 
                paciente.getApellidoPaterno(), 
                paciente.getApellidoMaterno(), 
                paciente.getFechaNacimiento(), 
                paciente.getTelefono(), 
                paciente.getCorreo(), 
                paciente.getDatosFiscales());
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
    protected Paciente convertirMapeoAEntidad(PacienteMapeo paciente){
        
        if (paciente.getDatosFiscales() != null) {
        return new Paciente(
                paciente.getNombre(), 
                paciente.getApellidoPaterno(), 
                paciente.getApellidoMaterno(), 
                paciente.getFechaNacimiento(), 
                paciente.getTelefono(), 
                paciente.getCorreo(), 
                paciente.getDatosFiscales());
        } 
        return new Paciente(
                paciente.getNombre(), 
                paciente.getApellidoPaterno(), 
                paciente.getApellidoMaterno(), 
                paciente.getFechaNacimiento(), 
                paciente.getTelefono(), 
                paciente.getCorreo());
    }
    
}
