package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

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
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException {

        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionPacientes = conexion.obtenerColeccion(cliente);

        try {
            coleccionPacientes.insertOne(paciente);
            logger.log(Level.INFO, "Se agrego al paciente");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar al paciente");
            throw new PersistenciaException("No se pudo registrar al paciente en la BD.");
        } finally {
            cliente.close();
        }

        return paciente;

    }

    @Override
    public List<Paciente> obtenerPacientes() throws PersistenciaException {

        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionPacientes = conexion.obtenerColeccion(cliente);

        List<Paciente> pacientes = new LinkedList<>();
        
        try {
            FindIterable<Paciente> cursor = coleccionPacientes.find();

            MongoCursor<Paciente> iterator = cursor.iterator();
            while (iterator.hasNext()) {
                pacientes.add(iterator.next());
            }
            logger.log(Level.INFO, "Se obtuvieron los pacientes");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener los pacientes");
            throw new PersistenciaException("No se pudo obtener la lista de pacientes de la BD.");
        } finally {
            cliente.close();
        }

        return pacientes;

    }

    @Override
    public Paciente obtenerPaciente(ObjectId id) throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionPacientes = conexion.obtenerColeccion(cliente);
        Paciente paciente;
        
        try {
            paciente = (Paciente) coleccionPacientes.find(eq("_id", id)).first();
            if (paciente != null) {
                logger.log(Level.INFO, "Se encontro al paciente");
            } else {
                logger.log(Level.INFO, "No se encontro al paciente");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar el paciente", e);
            throw new PersistenciaException("No se pudo obtener el paciente de la BD.", e);
        } finally {
            cliente.close();
        }
        
        return paciente;
    }

    @Override
    public Paciente agregarDatosFiscales(Paciente paciente) throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionPacientes = conexion.obtenerColeccion(cliente);
        
        try {
            UpdateResult updateResult = coleccionPacientes.updateOne(eq("_id", paciente.getId()), 
                    set("datosFiscales", paciente.getDatosFiscales()));
            if (updateResult.wasAcknowledged()) {
                logger.log(Level.INFO, "Se modifico al paciente");
            } else {
                paciente = null;
                logger.log(Level.INFO, "No se modifico al paciente");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar el paciente", e);
            throw new PersistenciaException("No se pudo obtener el paciente de la BD.", e);
        } finally {
            cliente.close();
        }
        
        return paciente;
        
    }

}
