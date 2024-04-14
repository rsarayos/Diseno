package citas_medicas_dao;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alex_
 */
public class CitaDAO implements ICitaDAO {

    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(CitaDAO.class.getName());

    public CitaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Cita agregarCita(Cita cita) throws PersistenciaException {
        
        EntityManager entityManager = conexion.crearConexion();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(cita);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agrego la cita");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar la cita");
            throw new PersistenciaException("No se pudo registrar la cita en la BD.");
        } finally {
            entityManager.close();
        }

        return cita;

    }

    @Override
    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        try {
            entityManager.getTransaction().begin();

            // Consulta JPQL para obtener la cita con la fechaHora y medico especificados
            Query query = entityManager.createQuery("SELECT c FROM Cita c WHERE c.fechaHora = :fechaHora AND c.medico = :medico", Cita.class);
            query.setParameter("fechaHora", fecha);
            query.setParameter("medico", medico);

            // Obtener el resultado de la consulta
            List<Cita> resultados = query.getResultList();

            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Consulta de cita realizada con éxito");

            // Devolver la primera cita encontrada (si hay alguna)
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar la cita");
            throw new PersistenciaException("Error al consultar la cita en la BD.");
        } finally {
            entityManager.close();
        }
    }
    
}
