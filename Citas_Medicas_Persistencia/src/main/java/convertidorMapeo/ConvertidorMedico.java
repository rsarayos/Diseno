package convertidorMapeo;

import entidades.Medico;
import entidadesMapeo.MedicoMapeo;

/**
 * Clase auxiliar para convertir objetos de tipo Medico y MedicoMapeo
 */
public class ConvertidorMedico {
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param medico entidad a convertir
     * @return un objeto de tipo MedicoMapeo
     */
    protected MedicoMapeo convertirEntidadAMapeo(Medico medico){
        
        if (medico.getDatosFiscales() != null) {
        return new MedicoMapeo(
                medico.getCedulaProfesional(), 
                medico.getNombre(), 
                medico.getApellidoPaterno(), 
                medico.getApellidoMaterno(), 
                medico.getFechaNacimiento(), 
                medico.getEspecialidad(), 
                medico.getTelefono(), 
                medico.getCorreo(), 
                medico.getContrasenia(), 
                medico.getDatosFiscales());
        } 
        return new MedicoMapeo(
                medico.getCedulaProfesional(), 
                medico.getNombre(), 
                medico.getApellidoPaterno(), 
                medico.getApellidoMaterno(), 
                medico.getFechaNacimiento(), 
                medico.getEspecialidad(), 
                medico.getTelefono(), 
                medico.getCorreo(), 
                medico.getContrasenia());
    }
    
    /**
     * Metodo para convertir una entidad de mapeo a una entidad para el sistema de citas medicas
     * @param medico entidad a convertir
     * @return un objeto de tipo Medico
     */
    protected Medico convertirMapeoAEntidad(MedicoMapeo medico){
    
        if (medico.getDatosFiscales() != null) {
        return new Medico(
                medico.getCedulaProfesional(), 
                medico.getNombre(), 
                medico.getApellidoPaterno(), 
                medico.getApellidoMaterno(), 
                medico.getFechaNacimiento(), 
                medico.getEspecialidad(), 
                medico.getTelefono(), 
                medico.getCorreo(), 
                medico.getContrasenia(), 
                medico.getDatosFiscales());
        } 
        return new Medico(
                medico.getCedulaProfesional(), 
                medico.getNombre(), 
                medico.getApellidoPaterno(), 
                medico.getApellidoMaterno(), 
                medico.getFechaNacimiento(), 
                medico.getEspecialidad(), 
                medico.getTelefono(), 
                medico.getCorreo(), 
                medico.getContrasenia());
    }
    
}
