package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import convertidorMapeo.ConvertidorMedico;
import entidades.Medico;
import entidadesMapeo.MedicoMapeo;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;
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
public class MedicoDAO implements IMedicoDAO{
    
    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;
    
    private ConvertidorMedico conv;
    
    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(MedicoDAO.class.getName());

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @param conexion Objeto para manejar la conexión a la base de datos.
     */
    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
        this.conv = new ConvertidorMedico();
    }

    @Override
    public void agregarMedicos() throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionMedico = conexion.obtenerColeccion(cliente);
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(Calendar.YEAR, 1990);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        
        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", calendar.getTime(), "Pediatría", "5551234567", "juan@example.com", "Contra");
               
        try {
            coleccionMedico.insertOne(medico1);
            logger.log(Level.INFO, "Se agrego al medico");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar al medico");
            throw new PersistenciaException("No se pudo registrar al medico en la BD.");
        } finally {
            cliente.close();
        }
        
    }

    @Override
    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionMedico = conexion.obtenerColeccion(cliente);
        MedicoMapeo medicoObt;
        
        try {       
            medicoObt = (MedicoMapeo) coleccionMedico.find(eq("cedulaProfesional", cedula)).first();
            if (medicoObt != null) {
                logger.log(Level.INFO, "Se encontro un medico");
            } else {
                logger.log(Level.INFO, "No se encontro al medico");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener al medico");
            throw new PersistenciaException("No se pudo obtener al medico.");
        } finally {
            cliente.close();
        }

        return conv.convertirMapeoAEntidad(medicoObt);
    }

    @Override
    public Medico agregarDatosFiscales(Medico medico) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionMedicos = conexion.obtenerColeccion(cliente);
        
        try {
            UpdateResult updateResult = coleccionMedicos.updateOne(eq("cedulaProfesional", medico.getCedulaProfesional()), 
                    set("datosFiscales", medico.getDatosFiscales()));
            if (updateResult.wasAcknowledged()) {
                logger.log(Level.INFO, "Se modifico al medico");
            } else {
                medico = null;
                logger.log(Level.INFO, "No se modifico al medico");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar el medico", e);
            throw new PersistenciaException("No se pudo obtener el medico de la BD.", e);
        } finally {
            cliente.close();
        }
        
        return medico;
        
    }

}
