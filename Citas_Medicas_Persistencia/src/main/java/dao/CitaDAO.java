package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import entidades.Cita;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

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
public class CitaDAO implements ICitaDAO {

    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;
    
    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(CitaDAO.class.getName());

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @param conexion Objeto para manejar la conexión a la base de datos.
     */
    public CitaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Cita agregarCita(Cita cita) throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);

        try {
            coleccionCitas.insertOne(cita);
            logger.log(Level.INFO, "Se agrego la cita");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar la cita");
            throw new PersistenciaException("No se pudo registrar la cita en la BD.");
        } finally {
            cliente.close();
        }

        return cita;

    }

    @Override
    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);

        try {
            FindIterable<Cita> cursor = coleccionCitas.find(and(
                    eq("cedulaProfesional", medico.getCedulaProfesional()),
                    eq("fechaHora", fecha.getTime())
            ));
            MongoCursor<Cita> iterator = cursor.iterator();
            List<Cita> resultados = new LinkedList<>();
            while (iterator.hasNext()) {
                resultados.add(iterator.next());
            }
            logger.log(Level.INFO, "Consulta de cita realizada con éxito");
            // Devolver la primera cita encontrada (si hay alguna)
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar la cita");
            throw new PersistenciaException("Error al consultar la cita en la BD.");
        } finally {
            cliente.close();
        }
    }

}
