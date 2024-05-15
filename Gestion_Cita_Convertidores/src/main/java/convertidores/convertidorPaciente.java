/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import EntidadesDTO.pacienteDTOs;
import dtos.PacienteDTO;

/**
 *
 * @author JESUS
 */
public class convertidorPaciente {
    
    public pacienteDTOs convertirDTOAEntidad(PacienteDTO paciente){
        return new pacienteDTOs(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getFechaNacimiento(), paciente.getEdad(), paciente.getTelefono(), paciente.getCorreo());
    }
    
    public PacienteDTO convertirEntidadADTO(pacienteDTOs paciente){
        return new PacienteDTO(paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getFechaNacimiento(), paciente.getEdad(), paciente.getTelefono(), paciente.getCorreo());
    }
    
}
