/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultarmedicoconvertidor.Convertidor;

import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmedicopersistencia.POJO.Medico;

/**
 * Clase que proporciona métodos para convertir entre objetos de tipo Medico y
 * MedicoDTO.
 *
 * Esta clase se utiliza para realizar la conversión entre entidades de Medico y
 * sus respectivos DTO (Data Transfer Objects). Los métodos en esta clase
 * permiten convertir objetos de tipo Medico a MedicoDTO y viceversa.
 *
 */
public class ConvertidorMedico {

    /**
     * Constructor predeterminado de ConvertidorMedico.
     */
    public ConvertidorMedico() {
    }

    /**
     * Convierte un objeto de tipo MedicoDTO a un objeto de tipo Medico.
     *
     * @param m El objeto de tipo MedicoDTO que se va a convertir.
     * @return Un objeto de tipo Medico resultante de la conversión.
     */
    public Medico convertidorDTOAEntidad(MedicoDTO m) {

        return new Medico(
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getCedula(),
                m.getEspecialidad(),
                m.getPassword()
        );
    }

    /**
     * Convierte un objeto de tipo Medico a un objeto de tipo MedicoDTO.
     *
     * @param m El objeto de tipo Medico que se va a convertir.
     * @return Un objeto de tipo MedicoDTO resultante de la conversión.
     */
    public MedicoDTO convertidorEntidadaADTO(Medico m) {

        return new MedicoDTO(
                m.getCedula(),
                m.getNombre(),
                m.getApellidoPaterno(),
                m.getApellidoMaterno(),
                m.getEspecialidad(),
                m.getPassword()
        );
    }
}