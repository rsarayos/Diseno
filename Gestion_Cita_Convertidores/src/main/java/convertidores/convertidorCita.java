/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;
import dtos.CitaDTO;
import dtos.PacienteDTO;
import EntidadesDTO.citaDTOs;
import EntidadesDTO.pacienteDTOs;
/**
 * Clase para converti entidades a DTOs y viceverssa
 * @author JESUS
 */
public class convertidorCita {
    
    /**
     * Constructor vacio
     */
    public convertidorCita(){
        
    }
    
    
    /**
     * Metodo para convertir DTO a entidad
     * @param cita citaDTO que se quiere convertir
     * @return la cita
     */
    public citaDTOs convertidorDTOAEntidad(CitaDTO cita){
        return new citaDTOs(
                cita.getFechaHora(), 
                cita.getCedulaProfesional(), 
                cita.getPaciente(), 
                cita.getObservacion(), 
                cita.isEstado()
        );
        
    }
    
    /**
     * Metodo para convertir a entidad a DTO
     * @param cita cita que quiere convetir
     * @return la cita
     */
    public CitaDTO convertidorEntidadADTO(citaDTOs cita){
        if (cita != null) {
            return new CitaDTO(cita.getFechaHora(), cita.getCedulaProfesional(), cita.getPaciente(), cita.getObservacion(),cita.getEstado());
        }else{
            return null;
        }    
    }
    
}
