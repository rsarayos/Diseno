package pruebasPersistencia;

import citas_medicas_dao.Conexion;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.MedicoDAO;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
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
            medicoDAO.agregarMedicos();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersistenciaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
//
//            Medico medico = medicoDAO.obtenerMedicoCedula("12345678");
//            System.out.println(medico.toString());
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PruebasPersistenciaMedico.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
