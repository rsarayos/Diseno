package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import static dao.PacienteDAO.logger;
import entidades.Factura;
import excepcionesPersistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Implementación de la interfaz IFacturaDAO que proporciona métodos para
 * operaciones relacionadas con facturas en la base de datos.
 */
public class FacturaDAO implements IFacturaDAO {

    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;
    
    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(FacturaDAO.class.getName());

    /**
     * Constructor de FacturaDAO que recibe una instancia de IConexion.
     *
     * @param conexion Objeto para manejar la conexión a la base de datos.
     */
    public FacturaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Factura registrarFactura(Factura factura) throws PersistenciaException {

        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionFacturas = conexion.obtenerColeccion(cliente);

        try {
            coleccionFacturas.insertOne(factura);
            logger.log(Level.INFO, "Se registro la factura");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar la factura", e);
            throw new PersistenciaException("No se pudo obtener el medico de la BD.", e);
        } finally {
            cliente.close();
        }

        return factura;
        
    }
    
}
