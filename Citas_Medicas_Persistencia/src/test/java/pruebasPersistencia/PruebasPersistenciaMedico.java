package pruebasPersistencia;

import dao.Conexion;
import dao.IConexion;
import dao.IMedicoDAO;
import dao.MedicoDAO;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class PruebasPersistenciaMedico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexion conexion = new Conexion();
        
        IMedicoDAO medicoDAO = new MedicoDAO(conexion);
        
        try {
//            medicoDAO.agregarMedicos();
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PruebasPersistenciaMedico.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
            Medico medico = medicoDAO.obtenerMedicoCedula("12345678");
            System.out.println(medico.toString());
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersistenciaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
