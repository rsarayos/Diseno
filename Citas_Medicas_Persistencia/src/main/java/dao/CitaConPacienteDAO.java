package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UnwindOptions;
import convertidorMapeo.ConvertidorCitaConPaciente;
import entidades.Cita;
import entidades.CitaConPaciente;
import entidadesMapeo.CitaConPacienteMapeo;
import excepcionesPersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Clase DAO de citas con metodos de accion
 */
public class CitaConPacienteDAO implements ICitaConPacienteDAO {

    /**
     * Objeto para manejar la conexión a la base de datos.
     */
    private final IConexion conexion;
    private ConvertidorCitaConPaciente conv;

    /**
     * Logger para registrar información y errores.
     */
    static final Logger logger = Logger.getLogger(CitaDAO.class.getName());
    
    public CitaConPacienteDAO(IConexion conexion) {
        this.conexion = conexion;
        this.conv = new ConvertidorCitaConPaciente();
    }
    
    @Override
    public List<CitaConPaciente> obtenerCitas(Cita cita) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);
        
        List<CitaConPacienteMapeo> citasColeccionadas = new ArrayList<>();
        List<CitaConPaciente> citasCon = new ArrayList<>();
        
        try {
            Bson cedulaFilter = Filters.eq("cedulaProfesional", cita.getCedulaProfesional());
            
            citasColeccionadas = (List<CitaConPacienteMapeo>) coleccionCitas.aggregate(
                    Arrays.asList(
                            // Filtrar documentos en la colección 'citas' según la cédula profesional
                            Aggregates.match(cedulaFilter),
                            // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                            Aggregates.lookup("pacientes", "idPaciente", "_id", "pacienteInfo"),
                            // Manejar los casos donde 'pacienteInfo' puede estar vacío
                            Aggregates.unwind("$pacienteInfo", new UnwindOptions().preserveNullAndEmptyArrays(true)),
                            // Proyectar los campos necesarios, asegurando que todas las partes del documento sean incluidas
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.include("_id", "fechaHora", "cedulaProfesional", "estado"),
                                            Projections.computed("observacion", "$observacion"), // Explicitamente incluir 'observacion'
                                            Projections.computed("paciente", "$pacienteInfo") // Asigna el documento paciente directamente
                                    )
                            )
                    )
            ).into(new ArrayList<>());
            for (CitaConPacienteMapeo ci : citasColeccionadas) {
                citasCon.add(conv.convertirMapeoAEntidad(ci));
            }
            
            return citasCon;
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar citas{0}", e);
            throw new PersistenciaException("No se pudo obtener todas las citas" + e);
        } finally {
            cliente.close();
        }
    }
    
    @Override
    public List<CitaConPaciente> consultarPorNombre(String cedulaMedico, String nombrePaciente) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);
        
        List<CitaConPacienteMapeo> citasColeccionadas = new ArrayList<>();
        List<CitaConPaciente> citasCon = new ArrayList<>();
        
        try {
            
            Bson cedulaFilter = Filters.eq("cedulaProfesional", cedulaMedico);
            Bson nombreFilter = Filters.regex("pacienteInfo.nombre", nombrePaciente);
            citasColeccionadas = (List<CitaConPacienteMapeo>) coleccionCitas.aggregate(
                    Arrays.asList(
                            // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                            Aggregates.lookup("pacientes", "idPaciente", "_id", "pacienteInfo"),
                            // Manejar los casos donde 'pacienteInfo' puede estar vacío
                            Aggregates.unwind("$pacienteInfo", new UnwindOptions().preserveNullAndEmptyArrays(true)),
                            // Aplicar filtros después de unir la información del paciente
                            Aggregates.match(Filters.and(cedulaFilter, nombreFilter)),
                            // Proyectar los campos necesarios, asegurando que todas las partes del documento sean incluidas
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.include("_id", "fechaHora", "cedulaProfesional", "estado"),
                                            Projections.computed("observacion", "$observacion"), // Explicitamente incluir 'observacion'
                                            Projections.computed("paciente", "$pacienteInfo") // Asigna el documento paciente directamente
                                    )
                            )
                    )
            ).into(new ArrayList<>());
            
            for (CitaConPacienteMapeo ci : citasColeccionadas) {
                citasCon.add(conv.convertirMapeoAEntidad(ci));
            }
            
            return citasCon;
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar citas por nombre");
            throw new PersistenciaException("No se pudo obtener todas las citas por nombre");
        } finally {
            cliente.close();
        }
    }
    
    @Override
    public List<CitaConPaciente> consultarPorFecha(Cita citaFecha) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);
        
        List<CitaConPacienteMapeo> citasColeccionadas = new ArrayList<>();
        List<CitaConPaciente> citasCon = new ArrayList<>();
        Calendar fechaInicio = getStartOfDay(citaFecha.getFechaHora());
        Calendar fechaFinal = getEndOfDay(citaFecha.getFechaHora());
        
        try {
            // Crear filtro para la fecha y la cédula profesional, si es necesario
            Bson filtroFecha = Filters.and(
                    Filters.gte("fechaHora", fechaInicio.getTime()),
                    Filters.lte("fechaHora", fechaFinal.getTime())
            );
            
            Bson filtroCedula = Filters.eq("cedulaProfesional", citaFecha.getCedulaProfesional());

            // Combinar ambos filtros
            Bson filtroCombinado = Filters.and(filtroFecha, filtroCedula);
            
            citasColeccionadas = (List<CitaConPacienteMapeo>) coleccionCitas.aggregate(
                    Arrays.asList(
                            // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                            Aggregates.lookup("pacientes", "idPaciente", "_id", "pacienteInfo"),
                            // Manejar los casos donde 'pacienteInfo' puede estar vacío
                            Aggregates.unwind("$pacienteInfo", new UnwindOptions().preserveNullAndEmptyArrays(true)),
                            // Aplicar el filtro combinado de fecha y cédula profesional
                            Aggregates.match(filtroCombinado),
                            // Proyectar los campos necesarios, asegurando que todas las partes del documento sean incluidas
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.include("_id", "fechaHora", "cedulaProfesional", "estado"),
                                            Projections.computed("observacion", "$observacion"),
                                            Projections.computed("paciente", "$pacienteInfo") // Asigna el documento paciente directamente
                                    )
                            )
                    )
            ).into(new ArrayList<>());
            
            for (CitaConPacienteMapeo ci : citasColeccionadas) {
                citasCon.add(conv.convertirMapeoAEntidad(ci));
            }
            
            return citasCon;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar citas por fecha");
            throw new PersistenciaException("No se pudo obtener todas las citas por fecha");
        } finally {
            cliente.close();
        }
    }
    
    @Override
    public List<CitaConPaciente> consultaPorHora(Cita citaHora) throws PersistenciaException {
        MongoClient cliente = conexion.obtenerConexion();
        MongoCollection coleccionCitas = conexion.obtenerColeccion(cliente);
        
        List<CitaConPacienteMapeo> citasColeccionadas = new ArrayList<>();
        List<CitaConPaciente> citasCon = new ArrayList<>();
        
        try {
            
            int hora = citaHora.getFechaHora().getHours(); // Asume que se usa Date.getHour()
            int minuto = citaHora.getFechaHora().getMinutes(); // Asume que se usa Date.getMinutes()

            List<Bson> pipeline = Arrays.asList(
                    // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                    Aggregates.lookup("pacientes", "idPaciente", "_id", "pacienteInfo"),
                    // Manejar los casos donde 'pacienteInfo' puede estar vacío
                    Aggregates.unwind("$pacienteInfo", new UnwindOptions().preserveNullAndEmptyArrays(true)),
                    // Extraer la hora y los minutos del campo 'fechaHora'
                    Aggregates.project(Projections.fields(
                            Projections.include("cedulaProfesional", "fechaHora", "observacion", "estado", "_id"),
                            Projections.computed("hora", new Document("$hour", "$fechaHora")),
                            Projections.computed("minuto", new Document("$minute", "$fechaHora")),
                            Projections.computed("paciente", "$pacienteInfo")
                    )),
                    // Filtrar por cédula profesional, hora y minuto
                    Aggregates.match(Filters.and(
                            Filters.eq("cedulaProfesional", citaHora.getCedulaProfesional()),
                            Filters.eq("hora", hora),
                            Filters.eq("minuto", minuto)
                    ))
            );
            
            citasColeccionadas = (List<CitaConPacienteMapeo>) coleccionCitas.aggregate(pipeline).into(new ArrayList<>());
            
            for (CitaConPacienteMapeo ci : citasColeccionadas) {
                citasCon.add(conv.convertirMapeoAEntidad(ci));
            }
            
            return citasCon;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar citas por hora", e);
            throw new PersistenciaException("No se pudo obtener todas las citas por hora: " + e.getMessage());
        } finally {
            cliente.close();
        }
    }

    /**
     * Obtiene el inicio del día para una fecha dada.
     *
     * @param date Fecha para calcular el inicio del día.
     * @return Calendar configurado al inicio del día de la fecha dada.
     * @throws PersistenciaException Si ocurre un error al calcular.
     */
    private Calendar getStartOfDay(Date date) throws PersistenciaException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * Obtiene el fin del día para una fecha dada.
     *
     * @param date Fecha para calcular el fin del día.
     * @return Calendar configurado al final del día de la fecha dada.
     * @throws PersistenciaException Si ocurre un error al calcular.
     */
    private Calendar getEndOfDay(Date date) throws PersistenciaException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }
    
}
