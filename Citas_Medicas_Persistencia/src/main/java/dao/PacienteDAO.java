package dao;

import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 * Clase que implementa la interfaz IPacienteDAO para el acceso a datos de pacientes.
 * 
 * Esta clase proporciona implementaciones para agregar pacientes a la base de datos,
 * obtener la lista de pacientes y obtener un paciente por su ID.
 * 
 * Se utiliza un objeto de tipo IConexion para obtener una instancia de EntityManager
 * y así interactuar con la base de datos.
 * 
 */
public class PacienteDAO implements IPacienteDAO{
    
    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;
    
    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @param conexion Objeto para manejar la conexión a la base de datos.
     */
    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarPacientes() throws PersistenciaException {
        
        EntityManager entityManager = conexion.crearConexion();
                
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(new Paciente("Juan", "García", "López", new GregorianCalendar(1985, 5, 15), "5551234567", "juan@example.com"));
            entityManager.persist(new Paciente("María", "Rodríguez", "Martínez", new GregorianCalendar(1990, 9, 22), "5552345678", "maria@example.com"));
            entityManager.persist(new Paciente("José", "Pérez", "Hernández", new GregorianCalendar(1978, 3, 10), "5553456789", "jose@example.com"));
            entityManager.persist(new Paciente("Ana", "Gómez", "Díaz", new GregorianCalendar(1982, 8, 7), "5554567890", "ana@example.com"));
            entityManager.persist(new Paciente("Pedro", "Sánchez", "López", new GregorianCalendar(1995, 11, 25), "5555678901", "pedro@example.com"));
            entityManager.persist(new Paciente("Laura", "Torres", "González", new GregorianCalendar(1989, 2, 14), "5556789012", "laura@example.com"));
            entityManager.persist(new Paciente("Carlos", "Ramírez", "Vázquez", new GregorianCalendar(1980, 6, 30), "5557890123", "carlos@example.com"));
            entityManager.persist(new Paciente("Sofía", "Hernández", "Fernández", new GregorianCalendar(1993, 12, 18), "5558901234", "sofia@example.com"));
            entityManager.persist(new Paciente("Alejandro", "Díaz", "Martínez", new GregorianCalendar(1987, 4, 3), "5559012345", "alejandro@example.com"));
            entityManager.persist(new Paciente("Lucía", "Vázquez", "Sánchez", new GregorianCalendar(1998, 7, 11), "5550123456", "lucia@example.com"));
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregaron los pacientes");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar a los pacientes");
            throw new PersistenciaException("No se pudieron registrar los pacientes en la BD.");
        } finally {
            entityManager.close();
        }
        
    }

    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException {

        EntityManager entityManager = conexion.crearConexion();

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agrego al paciente");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar al paciente");
            throw new PersistenciaException("No se pudo registrar al paciente en la BD.");
        } finally {
            entityManager.close();
        }

        return paciente;

    }

    @Override
    public List<Paciente> obtenerPacientes() throws PersistenciaException {
        
        EntityManager entityManager = conexion.crearConexion();
        List<Paciente> pacientes = null;

        try {
            entityManager.getTransaction().begin();
            pacientes = entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se obtuvieron los pacientes");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener los pacientes");
            throw new PersistenciaException("No se pudo obtener la lista de pacientes de la BD.");
        } finally {
            entityManager.close();
        }

        return pacientes;
        
    }

    @Override
    public Paciente obtenerPaciente(Long id) throws PersistenciaException {
        
        EntityManager entityManager = conexion.crearConexion();
        Paciente paciente;
        
        try {
            paciente = entityManager.find(Paciente.class, id);
            if (paciente != null) {
                logger.log(Level.INFO, "Se encontro al paciente");
            } else {
                logger.log(Level.INFO, "No se encontro al paciente");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar el paciente", e);
            throw new PersistenciaException("No se pudo obtener el paciente de la BD.", e);
        } finally {
            entityManager.close();
        }
        
        return paciente;
    }

}
