/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import EntidadesDTO.citasConPacienteDTOs;
import dtos.CitasConPacienteDTO;
/**
 *
 * @author JESUS
 */
public class convertidorCitasConPaciente {
    convertidorPaciente cp= new convertidorPaciente();
    public citasConPacienteDTOs convetirDTOAEntidad(CitasConPacienteDTO cita){
        return new citasConPacienteDTOs(cita.getFechaHora(), cita.getCedulaProfesional(), cp.convertirDTOAEntidad(cita.getPaciente()), cita.getObservacion(), cita.getEstado());
    }
    
    public CitasConPacienteDTO convertidorEntidadADTO(citasConPacienteDTOs cita){
        return new CitasConPacienteDTO(cita.getFechaHora(), cita.getCedulaProfesional(), cp.convertirEntidadADTO(cita.getPaciente()), cita.getObservacion(), cita.getEstado());
    }
}
