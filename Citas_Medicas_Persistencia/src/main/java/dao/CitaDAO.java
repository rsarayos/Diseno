package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.mongodb.client.model.Updates;
import convertidorMapeo.ConvertidorCita;
import entidades.Cita;
import entidades.Medico;
import entidadesMapeo.CitaMapeo;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

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
    private ConvertidorCita conv;

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
        this.conv = new ConvertidorCita();
    }

    @Override
    public Cita agregarCita(Cita cita) throws PersistenciaException {

        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);

        try {
            CitaMapeo c = conv.convertirEntidadAMapeo(cita);
            coleccionCitas.insertOne(c);
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
            FindIterable<CitaMapeo> cursor = coleccionCitas.find(and(
                    eq("cedulaProfesional", medico.getCedulaProfesional()),
                    eq("fechaHora", fecha.getTime())
            ));
            MongoCursor<CitaMapeo> iterator = cursor.iterator();
            List<Cita> resultados = new LinkedList<>();
            while (iterator.hasNext()) {
                resultados.add(conv.convertirMapeoAEntidad(iterator.next()));
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

    @Override
    public Cita cancelarCita(Cita citaCancelar) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);

        CitaMapeo c = conv.convertirEntidadAMapeo(citaCancelar);

        CitaMapeo citaBuscar = null;
        try {
            if (citaCancelar.getEstado()) {

                Bson filtroCombinado = Filters.and(
                        Filters.eq("fechaHora", c.getFechaHora()),
                        Filters.eq("cedulaProfesional", c.getCedulaProfesional())
                );
                citaBuscar = (CitaMapeo) coleccionCitas.find(filtroCombinado).first();

                if (citaBuscar != null) {
                    Bson updateOperation = Updates.set("estado", false);
                    coleccionCitas.updateOne(Filters.eq("_id", citaBuscar.getId()), updateOperation);
                    citaBuscar = (CitaMapeo) coleccionCitas.find(Filters.eq("_id", citaBuscar.getId())).first();

                } else {
                    throw new PersistenciaException("No se encontró la cita para cancelar");
                }
            }
            return conv.convertirMapeoAEntidad(citaBuscar);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al eliminar cita");
            throw new PersistenciaException("No se pudo eliminar la cita" + e);
        } finally {
            cliente.close();
        }
    }

    @Override
    public Cita ReasignarCita(Cita citaReasignar, Cita nueva) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);

        CitaMapeo cr = conv.convertirEntidadAMapeo(citaReasignar);
        CitaMapeo cn = conv.convertirEntidadAMapeo(nueva);

        CitaMapeo citaBuscar = null;
        try {
            if (citaReasignar.getEstado()) {
                Bson filtroCombinado = Filters.and(
                        Filters.eq("fechaHora", cr.getFechaHora()),
                        Filters.eq("cedulaProfesional", cr.getCedulaProfesional())
                );
                citaBuscar = (CitaMapeo) coleccionCitas.find(filtroCombinado).first();

                if (citaBuscar != null) {
                    Bson filtroActualizar = Filters.eq("_id", citaBuscar.getId());
                    Bson actualizacion = Updates.combine(
                            Updates.set("fechaHora", cn.getFechaHora()),
                            Updates.set("estado", cn.getEstado()) // Asegúrate de que el nuevo estado se pase correctamente
                    );
                    coleccionCitas.updateOne(filtroActualizar, actualizacion);
                    citaBuscar = (CitaMapeo) coleccionCitas.find(Filters.eq("_id", citaBuscar.getId())).first();
                } else {
                    throw new PersistenciaException("No se encontró la cita a reasignar.");
                }
            } else {
                throw new PersistenciaException("La cita no está en estado activo y no puede ser reasignada.");
            }
            return conv.convertirMapeoAEntidad(citaBuscar);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al reasignar cita ");
            throw new PersistenciaException("No se pudo reasignar ");
        } finally {
            cliente.close();
        }

    }

}
