/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convetidores;
import Entidades.Paciente;
import EntidadesDTO.pacienteDTOs;
import org.bson.types.ObjectId;
/**
 *
 * @author JESUS
 */
public class PacienteConvertidor {
     /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param paciente entidad a convertir
     * @return un objeto de tipo PacienteMapeo
     */
    public Paciente convertirEntidadAMapeo(pacienteDTOs paciente) {
        if (paciente.getId() != null) {
           
                
                ObjectId idPac = new ObjectId(paciente.getId());
                return new Paciente(idPac, paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getFechaNacimiento(), paciente.getEdad(), paciente.getTelefono(), paciente.getCorreo());
            
        }
         return new Paciente(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getFechaNacimiento(), paciente.getEdad(), paciente.getTelefono(), paciente.getCorreo());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param paciente entidad a convertir
     * @return un objeto de tipo Paciente
     */
    public pacienteDTOs convertirMapeoAEntidad(Paciente paciente) {
        if (paciente != null) {
            String idPac = paciente.getId().toHexString();

            
                return new pacienteDTOs(idPac, paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getFechaNacimiento(), paciente.getEdad(), paciente.getTelefono(), paciente.getCorreo());
            
        } else {
            return null;
        }
    }
}
