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
            Paciente pacientes = pacienteDAO.obtenerPacienteTelefono("6422352010");
            List<DatosFiscales> df = new LinkedList<>();
            DatosFiscales f = new DatosFiscales();
            f.setRazonSocial("dfsadfasf");
            f.setEstado("sadfasg");
            df.add(f);
            pacientes.setDatosFiscales(df);
            Paciente pacienteNuevo = pacienteDAO.agregarDatosFiscales(pacientes);
            System.out.println(pacienteNuevo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
