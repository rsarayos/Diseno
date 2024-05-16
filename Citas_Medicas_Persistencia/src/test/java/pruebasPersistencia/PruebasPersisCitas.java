package pruebasPersistencia;

import dao.CitaConPacienteDAO;
import dao.CitaDAO;
import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.ICitaConPacienteDAO;
import dao.ICitaDAO;
import dao.IConexion;
import dao.IMedicoDAO;
import dao.IPacienteDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import entidades.Cita;
import entidades.CitaConPaciente;
import entidades.Medico;
import entidades.Paciente;
import entidadesMapeo.CitaConPacienteMapeo;
import entidadesMapeo.CitaMapeo;
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
        IConexion conexionCita = new Conexion(ConstantesPersistencia.colecciones.CITAS, CitaMapeo.class);
        IConexion conexionCitaPaciente = new Conexion(ConstantesPersistencia.colecciones.CITAS, CitaConPacienteMapeo.class);
        IConexion conexionPaciente = new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class);

        ICitaDAO citaDAO = new CitaDAO(conexionCita);
        ICitaConPacienteDAO cpDAO = new CitaConPacienteDAO(conexionCitaPaciente);
        
        Cita cita = new Cita();
        cita.setCedulaProfesional("12345678");
        try {
            List<CitaConPaciente> citas = cpDAO.consultarPorNombre("12345678", "Joaquin");
            for (CitaConPaciente cita1 : citas) {
                System.out.println(cita1);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
