/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convetidores;
import Entidades.CitasConPaciente;
import EntidadesDTO.citasConPacienteDTOs;
import org.bson.types.ObjectId;

/**
 *
 * @author JESUS
 */
public class CitasConPacienteConvertidor {
    PacienteConvertidor cp=new PacienteConvertidor();
    
    public citasConPacienteDTOs convertirEntiadaADTOs(CitasConPaciente cita){
        if (cita!=null) {
            String idCit=cita.getId().toHexString();
            return new citasConPacienteDTOs(idCit, cita.getFechaHora(), cita.getCedulaProfesional(), cp.convertirMapeoAEntidad(cita.getPaciente()), cita.getObservacion(), cita.getEstado());
        }else{
            return null;
        }
       
    }

}
