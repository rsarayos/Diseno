package dao;

import entidades.Cita;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz ICitaDAO para el acceso a datos de citas médicas.
 * 
 * Esta clase proporciona implementaciones para agregar una nueva cita médica
 * y para consultar una cita con una fecha específica asociada a un médico.
 * 
 * Se utiliza un objeto de tipo IConexion para obtener una instancia de EntityManager
 * y así interactuar con la base de datos.
 * 
 */
public class CitaDAO  {

//    /**
//     * Objeto para manejar la conexión a la base de datos.
//     */
//    private final IConexion conexion;
//    
//    /**
//     * Logger para registrar información y errores.
//     */
//    static final Logger logger = Logger.getLogger(CitaDAO.class.getName());
//
//    /**
//     * Constructor que inicializa la conexión a la base de datos.
//     * 
//     * @param conexion Objeto para manejar la conexión a la base de datos.
//     */
//    public CitaDAO(IConexion conexion) {
//        this.conexion = conexion;
//    }
//    
//    @Override
//    public Cita agregarCita(Cita cita) throws PersistenciaException {
//        
//        EntityManager entityManager = conexion.crearConexion();
//
//        try {
//
//            entityManager.getTransaction().begin();
//            entityManager.persist(cita);
//            entityManager.getTransaction().commit();
//            logger.log(Level.INFO, "Se agrego la cita");
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al agregar la cita");
//            throw new PersistenciaException("No se pudo registrar la cita en la BD.");
//        } finally {
//            entityManager.close();
//        }
//
//        return cita;
//
//    }
//
//    @Override
//    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException {
//        EntityManager entityManager = conexion.crearConexion();
//
//        try {
//            entityManager.getTransaction().begin();
//
//             Consulta JPQL para obtener la cita con la fechaHora y medico especificados
//            Query query = entityManager.createQuery("SELECT c FROM Cita c WHERE c.fechaHora = :fechaHora AND c.medico = :medico", Cita.class);
//            query.setParameter("fechaHora", fecha);
//            query.setParameter("medico", medico);
//
//             Obtener el resultado de la consulta
//            List<Cita> resultados = query.getResultList();
//
//            entityManager.getTransaction().commit();
//            logger.log(Level.INFO, "Consulta de cita realizada con éxito");
//
//             Devolver la primera cita encontrada (si hay alguna)
//            return resultados.isEmpty() ? null : resultados.get(0);
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al consultar la cita");
//            throw new PersistenciaException("Error al consultar la cita en la BD.");
//        } finally {
//            entityManager.close();
//        }
//    }
    
}
