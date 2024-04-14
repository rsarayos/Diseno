package pruebasPersistencia;

import citas_medicas_dao.Conexion;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IPacienteDAO;
import citas_medicas_dao.PacienteDAO;
import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        
            //        try {
//            pacienteDAO.agregarPacientes();
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        try {
//            List<Paciente> pacientes = pacienteDAO.obtenerPacientes();
//            for (Paciente pa : pacientes) {
//                System.out.println(pa.toString());
//            }
//            
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            Paciente paciente = pacienteDAO.obtenerPaciente(1L);
            System.out.println(paciente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}