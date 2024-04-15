package citas_medicas_dao;

import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author alex_
 */
public class MedicoDAO implements IMedicoDAO {
    
    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarMedicos() throws PersistenciaException {
        
        EntityManager entityManager = conexion.crearConexion();
        
        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", new GregorianCalendar(1995, 5, 15), "Pediatría", "ABCR123456", "5551234567", "juan@example.com", "Contra");
               
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(medico1);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agrego al medico");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar al medico");
            throw new PersistenciaException("No se pudo registrar al medico en la BD.");
        } finally {
            entityManager.close();
        }
        
    }

    @Override
    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        Medico medicoObt;

        try {
            entityManager.getTransaction().begin();
            medicoObt = entityManager.find(Medico.class, cedula);

            if (medicoObt != null) {
                logger.log(Level.INFO, "Se encontro un medico");
            } else {
                logger.log(Level.INFO, "No se encontro al medico");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener al medico");
            throw new PersistenciaException("No se pudo obtener al medico.");
        } finally {
            entityManager.close();
        }

        return medicoObt;
    }

}
