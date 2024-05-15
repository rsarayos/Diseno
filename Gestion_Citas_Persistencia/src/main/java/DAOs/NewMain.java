/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOs;

import Entidades.Cita;
import Entidades.CitasConPaciente;
import Entidades.Paciente;
import EntidadesDTO.citaDTOs;
import EntidadesDTO.citasConPacienteDTOs;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author JESUS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CitaDAO c=new CitaDAO();
        //
        //c.inserccionMoco();
        
        try {
            citaDTOs cita=new citaDTOs();
            cita.setCedulaProfesional("CED123456789");
            GregorianCalendar fechaCalendario = new GregorianCalendar(2024, GregorianCalendar.MAY, 20); // Año, Mes, Día
            fechaCalendario.set(GregorianCalendar.HOUR_OF_DAY, 19);
            fechaCalendario.set(GregorianCalendar.MINUTE, 0);
            fechaCalendario.set(GregorianCalendar.SECOND, 0);
            fechaCalendario.set(GregorianCalendar.MILLISECOND, 0);

            // Convertir GregorianCalendar a Date
            Date fechaDeConsulta = fechaCalendario.getTime();
            cita.setFechaHora(fechaDeConsulta);
            
            Paciente p= new Paciente();
            p.setNombre("Elena");
            List<citasConPacienteDTOs> citas = c.consultaPorHora(cita);

            // Verificar si se obtuvieron citas
            if (citas != null) {
                // Si hay citas, imprimir cada cita
                for (citasConPacienteDTOs citaq : citas) {
                    System.out.println("ID: " + citaq.getId());
                    System.out.println("Fecha y Hora: " + citaq.getFechaHora());
                    System.out.println("Cedula Profesional: " + citaq.getCedulaProfesional());
                    System.out.println("Observacion: " + citaq.getObservacion());
                    System.out.println("Estado: " + citaq.getEstado());
                    System.out.println("Paciente: " + citaq.getPaciente().getNombre());
                    System.out.println("---------------------------------------");
                }
            } else {
                // Si no hay citas, imprimir un mensaje
                System.out.println("No se encontraron citas.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
