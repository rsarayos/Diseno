package pruebasPersistencia;

import dao.CitaDAO;
import dao.Conexion;
import dao.ConstantesPersistencia;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
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
        IConexion conexionCita = new Conexion(ConstantesPersistencia.colecciones.CITAS, Cita.class);

        IConexion conexionPaciente = new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class);

        ICitaDAO citaDAO = new CitaDAO(conexionCita);
        IPacienteDAO pacienteDAO = new PacienteDAO(conexionPaciente);

        List<Paciente> pacientes = new LinkedList<>();

        try {
            pacientes = pacienteDAO.obtenerPacientes();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0); 
        calendar.set(Calendar.SECOND, 0); 
        calendar.set(Calendar.MILLISECOND, 0);
        
        Cita cita = new Cita(calendar.getTime(), "12345678", pacientes.get(0).getId(), "chequeo", Boolean.FALSE);

        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", calendar.getTime(), "Pediatría", "5551234567", "juan@example.com", "Contra");
        
        try {
            Cita citaObt = citaDAO.consultarConFecha(calendar, medico1);
            System.out.println(citaObt);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
