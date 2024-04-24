package pruebasPersistencia;

import dao.CitaDAO;
import dao.Conexion;
import dao.ICitaDAO;
import dao.IConexion;
import dao.IMedicoDAO;
import dao.IPacienteDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class PruebasPersisCitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexion conexion = new Conexion();
        
        ICitaDAO citaDAO = new CitaDAO(conexion);
        IMedicoDAO medicoDAO = new MedicoDAO(conexion);
        IPacienteDAO pacienteDAO = new PacienteDAO(conexion);
        
//        try {
//            
//            List<Paciente> pacientes = pacienteDAO.obtenerPacientes();
//            Cita citaNueva = new Cita(new GregorianCalendar(2024, 3, 15, 10, 0), 
//                medico, 
//                pacientes.get(0), 
//                "Consulta general", 
//                true); 
//            citaDAO.agregarCita(citaNueva);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PruebasPersisCitas.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
        try {
            Medico medico = medicoDAO.obtenerMedicoCedula("12345678");
            Cita cita = citaDAO.consultarConFecha(new GregorianCalendar(2024, 3, 15, 9, 0), medico);
            System.out.println(cita);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
