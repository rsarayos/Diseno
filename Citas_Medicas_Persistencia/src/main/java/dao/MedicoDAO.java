package dao;

import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IMedicoDAO para el acceso a datos de médicos.
 * 
 * Esta clase proporciona implementaciones para agregar médicos a la base de datos
 * y para obtener un médico por su número de cédula.
 * 
 * Se utiliza un objeto de tipo IConexion para obtener una instancia de EntityManager
 * y así interactuar con la base de datos.
 * 
 */
public class MedicoDAO {
    
//    /**
//     * Objeto para manejar la conexión a la base de datos.
//     */
//    private final IConexion conexion;
//    
//    /**
//     * Logger para registrar información y errores.
//     */
//    static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());
//
//    /**
//     * Constructor que inicializa la conexión a la base de datos.
//     * 
//     * @param conexion Objeto para manejar la conexión a la base de datos.
//     */
//    public MedicoDAO(IConexion conexion) {
//        this.conexion = conexion;
//    }
//
//    @Override
//    public void agregarMedicos() throws PersistenciaException {
//        
////        EntityManager entityManager = conexion.crearConexion();
////        
//////        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", new GregorianCalendar(1995, 5, 15), "Pediatría", "ABCR123456", "5551234567", "juan@example.com", "Contra");
////               
////        try {
////
////            entityManager.getTransaction().begin();
////            entityManager.persist(medico1);
////            entityManager.getTransaction().commit();
////            logger.log(Level.INFO, "Se agrego al medico");
////        } catch (Exception e) {
////            logger.log(Level.SEVERE, "Error al agregar al medico");
////            throw new PersistenciaException("No se pudo registrar al medico en la BD.");
////        } finally {
////            entityManager.close();
////        }
//        
//    }
//
//    @Override
//    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException {
//        EntityManager entityManager = conexion.crearConexion();
//        Medico medicoObt;
//
//        try {
//            entityManager.getTransaction().begin();
//            medicoObt = entityManager.find(Medico.class, cedula);
//
//            if (medicoObt != null) {
//                logger.log(Level.INFO, "Se encontro un medico");
//            } else {
//                logger.log(Level.INFO, "No se encontro al medico");
//            }
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al obtener al medico");
//            throw new PersistenciaException("No se pudo obtener al medico.");
//        } finally {
//            entityManager.close();
//        }
//
//        return medicoObt;
//    }

}
