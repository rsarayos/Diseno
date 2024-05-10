package pruebasPersistencia;

import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.IConexion;
import dao.IMedicoDAO;
import dao.MedicoDAO;
import entidades.DatosFiscales;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
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
        
        IConexion conexion = new Conexion(ConstantesPersistencia.colecciones.MEDICOS, Medico.class);
        
        IMedicoDAO medicoDAO = new MedicoDAO(conexion);
        
        DatosFiscales datos = new DatosFiscales("Juan Lopez Gomez", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba");
        List<DatosFiscales> datosFiscales = new LinkedList<>();
        datosFiscales.add(datos);
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(Calendar.YEAR, 1990);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", calendar.getTime(), "Pediatría", "ABCR123456", "5551234567", "juan@example.com", "Contra");
        medico1.setDatosFiscales(datosFiscales);
        
        
        try {
            medicoDAO.agregarDatosFiscales(medico1);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersistenciaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
