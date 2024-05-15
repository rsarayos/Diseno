/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convetidores;

import EntidadesDTO.citaDTOs;
import Entidades.Cita;
import org.bson.types.ObjectId;
/**
 *
 * @author JESUS
 */
public class CitaConvertidor {
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo CitaMapeo
     */
    public Cita convertirEntidadAMapeo(citaDTOs cita){
        
        ObjectId idPac = new ObjectId(cita.getPaciente());
        
        return new Cita(
                cita.getFechaHora(),
                cita.getCedulaProfesional(),
                idPac,
                cita.getObservacion(),
                cita.getEstado());
    }
    
    /**
     * Metodo para convertir una entidad a una entidad de mapeo para la base de datos
     * @param cita entidad a convertir
     * @return un objeto de tipo Paciente
     */
    public citaDTOs convertirMapeoAEntidad(Cita cita) {
        if (cita != null) {
            String idCit = cita.getId().toHexString();
            String idPac = cita.getPaciente().toHexString();

            return new citaDTOs(
                    idCit,
                    cita.getFechaHora(),
                    cita.getCedulaProfesional(),
                    idPac,
                    cita.getObservacion(),
                    cita.isEstado());
        } else {
            return null;
        }
    }
}
