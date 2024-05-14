/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;
import dtos.CitaDTO;
import dtos.PacienteDTO;
import Entidades.Cita;
import Entidades.Paciente;
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
    public Cita convertidorDTOAEntidad(CitaDTO cita){
        Paciente paciente=new Paciente();
        if (cita.getPaciente()!=null) {
            paciente.setNombre(cita.getPaciente().getNombre());
            paciente.setApellidoPaterno(cita.getPaciente().getApellidoPaterno());
            paciente.setApellidoMaterno(cita.getPaciente().getApellidoMaterno());
            paciente.setCorreo(cita.getPaciente().getCorreo());
            paciente.setTelefono(cita.getPaciente().getTelefono());
            paciente.setFechaNacimiento(cita.getPaciente().getFechaNacimiento());
        }
       
        
        return new Cita(cita.getFechaHora(), cita.getCedulaProfesional(), paciente, cita.getObservacion(), cita.isEstado());
        
    }
    
    /**
     * Metodo para convertir a entidad a DTO
     * @param cita cita que quiere convetir
     * @return la cita
     */
    public CitaDTO convertidorEntidadADTO(Cita cita){
        PacienteDTO paciente=new PacienteDTO();
        paciente.setNombre(cita.getPaciente().getNombre());
        paciente.setApellidoPaterno(cita.getPaciente().getApellidoPaterno());
        paciente.setApellidoMaterno(cita.getPaciente().getApellidoMaterno());
        paciente.setCorreo(cita.getPaciente().getCorreo());
        paciente.setTelefono(cita.getPaciente().getTelefono());
        paciente.setFechaNacimiento(cita.getPaciente().getFechaNacimiento());
        
        return new CitaDTO(cita.getFechaHora(), cita.getCedulaProfesional(), paciente, cita.getObservacion(),cita.isEstado());
    }
    
}
