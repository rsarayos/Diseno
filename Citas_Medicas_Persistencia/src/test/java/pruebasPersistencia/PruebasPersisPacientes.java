package pruebasPersistencia;

import dao.Conexion;
import dao.IConexion;
import dao.IPacienteDAO;
import dao.PacienteDAO;
import entidades.DatosFiscales;
import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author alex_
 */
public class PruebasPersisPacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexion conexion = new Conexion();
        
        IPacienteDAO pacienteDAO = new PacienteDAO(conexion);
        
        Date fechaActual = new Date();
        
        Paciente paciente1 = new Paciente("Ricardo", "Gomez", "Valenzuela", fechaActual, 20, "6455332211", "ricardo@correo.com");
        DatosFiscales datos = new DatosFiscales("Juan Lopez Gomez", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba");
        List<DatosFiscales> datosFiscales = new LinkedList<>();
        datosFiscales.add(datos);
        paciente1.setDatosFiscales(datosFiscales);
                
        try {
            List<Paciente> pacientes = pacienteDAO.obtenerPacientes();
            Paciente pacienteModi = pacientes.get(0);
            pacienteModi.setDatosFiscales(datosFiscales);
            pacienteDAO.agregarDatosFiscales(pacienteModi);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
