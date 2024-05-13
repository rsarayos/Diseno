package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import entidades.Factura;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public Factura consultarUltimaFacturaMedico(Medico medico) throws PersistenciaException {
        
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionFacturas = conexion.obtenerColeccion(cliente);
        Factura factura;

        try {
            factura = (Factura) coleccionFacturas.find(
                    Filters.eq("rfcMedico", medico.getDatosFiscales().get(0).getRfc()))
                    .sort(Sorts.descending("folioInterno"))
                    .first();

            logger.log(Level.INFO, "Se consultaron las facturas");
            return factura;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar la factura", e);
            throw new PersistenciaException("No se pudo obtener las facturas de la BD.", e);
        } finally {
            cliente.close();
        }

    }
    
}
