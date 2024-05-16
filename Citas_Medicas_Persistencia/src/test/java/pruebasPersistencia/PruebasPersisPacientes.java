package pruebasPersistencia;

import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.IConexion;
import dao.IPacienteDAO;
import dao.PacienteDAO;
import entidades.DatosFiscales;
import entidades.Paciente;
import entidadesMapeo.PacienteMapeo;
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
        
        IConexion conexion = new Conexion(ConstantesPersistencia.colecciones.PACIENTES, PacienteMapeo.class);
        
        IPacienteDAO pacienteDAO = new PacienteDAO(conexion);
        
        Date fechaActual = new Date();
        
        
                
        try {
            Paciente paciente = pacienteDAO.obtenerPaciente("6642f2b2c3d9ac7e9f6fda20");
            System.out.println(paciente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
