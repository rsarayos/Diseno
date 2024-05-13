/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.consultarmedicopersistencia;

import com.mycompany.consultarmedicopersistencia.DAOS.MedicoDAO;
import com.mycompany.consultarmedicopersistencia.Excepciones.PersistenciaException;
import com.mycompany.consultarmedicopersistencia.POJO.Medico;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.consultarmedicopersistencia.DAOS.IMedicoDAO;

/**
 *
 * @author uirtis
 */
public class ConsultarMedicoPersistencia {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        IMedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = new Medico("Pepe", "Castelo", "Lopez", "123456", "Traumatología", "123456");
        Medico medico2 = new Medico("María", "García", "Fernández", "789012", "Pediatría", "789012");
        Medico medico3 = new Medico("Juan", "Pérez", "Martínez", "345678", "Cardiología", "345678");
        Medico medico4 = new Medico("Laura", "Rodríguez", "Sánchez", "901234", "Ginecología", "901234");
        Medico medico5 = new Medico("Carlos", "López", "García", "567890", "Traumatología", "567890");
        Medico medico6 = new Medico("Pepe", "Alvarez", "Valenzuela", "427381", "Pediatría", "789012");
        Medico medico7 = new Medico("Pepe", "González", "Galindo", "456789", "Neurología", "456789");
        
        /*
        try {
            medicoDAO.registrarMedico(medico);
            medicoDAO.registrarMedico(medico2);
            medicoDAO.registrarMedico(medico3);
            medicoDAO.registrarMedico(medico4);
            medicoDAO.registrarMedico(medico5);
            medicoDAO.registrarMedico(medico6);
            medicoDAO.registrarMedico(medico7);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultarMedicoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        try {
            System.out.println(medicoDAO.consultarMedico());

        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultarMedicoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        try {
            System.out.println(medicoDAO.buscarMedico("p", null, null));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultarMedicoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         /*
        try {
            medicoDAO.eliminarMedico(medico);
            System.out.println("Se elimino el medico correctamente");
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultarMedicoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
          */
    }
}
