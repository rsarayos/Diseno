/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consultarmedicobo;

import com.mycompany.consultarmedicobo.objetosNegocio.IMedicoNegocio;
import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uirtis
 */
public class ConsultarMedicoBO {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        IMedicoNegocio medicoNegocio = new MedicoNegocio();
        try {
            List<MedicoDTO> medicos = new ArrayList<>();
            medicos = medicoNegocio.consultarMedico();
        } catch (Exception e) {
        }
    }
}
