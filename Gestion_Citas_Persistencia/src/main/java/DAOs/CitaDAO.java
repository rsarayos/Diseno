/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import Convetidores.CitasConPacienteConvertidor;
import Convetidores.CitaConvertidor;
import Convetidores.PacienteConvertidor;
import excepciones.PersistenciaException;
import interfaces.ICitaDAO;
import Entidades.Cita;
import Entidades.CitasConPaciente;
import Entidades.Paciente;
import EntidadesDTO.citaDTOs;
import EntidadesDTO.citasConPacienteDTOs;
import EntidadesDTO.pacienteDTOs;
import java.util.List;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UnwindOptions;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase DAO de citas con metodos de accion
 * @author JESUS
 */
public class CitaDAO implements ICitaDAO{
    //Variables de la clase
    private final MongoCollection<Cita> coleccion;
    private PacienteDAO p;
    static final Logger logger = Logger.getLogger(CitaDAO.class.getName());
    CitasConPacienteConvertidor ccpc=new CitasConPacienteConvertidor();
    CitaConvertidor cc=new CitaConvertidor();
    PacienteConvertidor pc=new PacienteConvertidor();
    
    /**
     * Metodo para conectar a la base de datos y la coleccion
     */
    public CitaDAO(){
        this.coleccion=conexion.ConexionBD.getDatabase().getCollection("citas",Cita.class);
        p=new PacienteDAO();
    }
    
    /**
     * Obtiene una lista de citas de un medico en 
     * 
     * @param cita Objeto Cita con criterios específicos para la búsqueda.
     * @return Lista de objetos Cita que cumplen con los criterios.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<citasConPacienteDTOs> obtenerCitas(citaDTOs cita) throws PersistenciaException {
        List<CitasConPaciente> citasColeccionadas = new ArrayList<>();
        List<citasConPacienteDTOs> citasCon= new ArrayList<>();
        try {
            MongoCollection<CitasConPaciente> citasCollection = conexion.ConexionBD.getDatabase().getCollection("citas", CitasConPaciente.class);
        Bson cedulaFilter = Filters.eq("cedulaProfesional", cita.getCedulaProfesional());
        
        citasColeccionadas = citasCollection.aggregate(
            Arrays.asList(
                // Filtrar documentos en la colección 'citas' según la cédula profesional
                Aggregates.match(cedulaFilter),
                // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                Aggregates.lookup("pacientes", "paciente", "_id", "pacienteInfo"),
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
        for(CitasConPaciente ci: citasColeccionadas) {
                citasCon.add(ccpc.convertirEntiadaADTOs(ci));
        }
            
        return citasCon;
            
            
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al consultar citas"+e);
            throw new PersistenciaException("No se pudo obtener todas las citas"+e);
        }
    }

    /**
     * Consulta las citas por el nombre del paciente.
     * 
     * @param citaNombre Cita con el nombre del paciente como criterio de búsqueda.
     * @return Lista de citas que coinciden con el nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<citasConPacienteDTOs> consultarPorNombre(citaDTOs citaNombre,pacienteDTOs pacienteNombre) throws PersistenciaException {
        List<CitasConPaciente> citasColeccionadas = new ArrayList<>();
        List<citasConPacienteDTOs> citasCon= new ArrayList<>();
        try {
            MongoCollection<CitasConPaciente> citasCollection = conexion.ConexionBD.getDatabase().getCollection("citas", CitasConPaciente.class);
            Bson cedulaFilter = Filters.eq("cedulaProfesional", citaNombre.getCedulaProfesional());
            Bson nombreFilter = Filters.regex("pacienteInfo.nombre",pacienteNombre.getNombre() );
            citasColeccionadas = citasCollection.aggregate(
                Arrays.asList(
                    // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                    Aggregates.lookup("pacientes", "paciente", "_id", "pacienteInfo"),
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
            
            for(CitasConPaciente ci: citasColeccionadas) {
                citasCon.add(ccpc.convertirEntiadaADTOs(ci));
            }
            
            return citasCon;
            
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al consultar citas por nombre");
            throw new PersistenciaException("No se pudo obtener todas las citas por nombre");
        }
    }
    
    /**
     * Consulta las citas por fecha.
     * 
     * @param citaFecha Cita con la fecha específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa fecha.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<citasConPacienteDTOs> consularPorFecha(citaDTOs citaFecha) throws PersistenciaException {
            List<CitasConPaciente> citasColeccionadas = new ArrayList<>();
            Calendar fechaInicio=getStartOfDay(citaFecha.getFechaHora());
            Calendar fechaFinal=getEndOfDay(citaFecha.getFechaHora());
            List<citasConPacienteDTOs> citasCon= new ArrayList<>();
            
        try {   
             MongoCollection<CitasConPaciente> citasCollection = conexion.ConexionBD.getDatabase().getCollection("citas", CitasConPaciente.class);
            
            // Crear filtro para la fecha y la cédula profesional, si es necesario
            Bson filtroFecha = Filters.and(
                Filters.gte("fechaHora", fechaInicio.getTime()),
                Filters.lte("fechaHora", fechaFinal.getTime())
            );
            
             Bson filtroCedula = Filters.eq("cedulaProfesional", citaFecha.getCedulaProfesional());

            // Combinar ambos filtros
            Bson filtroCombinado = Filters.and(filtroFecha, filtroCedula);

            citasColeccionadas = citasCollection.aggregate(
                Arrays.asList(
                    // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                    Aggregates.lookup("pacientes", "paciente", "_id", "pacienteInfo"),
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

            for(CitasConPaciente ci: citasColeccionadas) {
                citasCon.add(ccpc.convertirEntiadaADTOs(ci));
            }
            
            return citasCon;
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al consultar citas por fecha");
            throw new PersistenciaException("No se pudo obtener todas las citas por fecha");
        }
    }
    
    /**
     * Consulta las citas por hora específica.
     * 
     * @param citaHora Cita con la hora específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa hora.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<citasConPacienteDTOs> consultaPorHora(citaDTOs citaHora) throws PersistenciaException {

        List<CitasConPaciente> citasColeccionadas = new ArrayList<>();
        List<citasConPacienteDTOs> citasCon= new ArrayList<>();
        try {
            MongoCollection<CitasConPaciente> citasCollection = conexion.ConexionBD.getDatabase().getCollection("citas", CitasConPaciente.class);

            int hora = citaHora.getFechaHora().getHours(); // Asume que se usa Date.getHour() (deprecated, consider using Calendar)
            int minuto = citaHora.getFechaHora().getMinutes(); // Asume que se usa Date.getMinutes() (deprecated, consider using Calendar)

            List<Bson> pipeline = Arrays.asList(
                // Realizar un lookup para unir información del paciente desde la colección 'pacientes'
                Aggregates.lookup("pacientes", "paciente", "_id", "pacienteInfo"),
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

            citasColeccionadas = citasCollection.aggregate(pipeline).into(new ArrayList<>());
            
            for(CitasConPaciente ci: citasColeccionadas) {
                citasCon.add(ccpc.convertirEntiadaADTOs(ci));
            }
            
            return citasCon;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al consultar citas por hora", e);
            throw new PersistenciaException("No se pudo obtener todas las citas por hora: " + e.getMessage());
        }
    }
    
    /**
     * Cancela una cita existente.
     * 
     * @param citaCancelar Cita a cancelar.
     * @return Cita cancelada.
     * @throws PersistenciaException Si ocurre un error durante la cancelación.
     */
    @Override
    public citaDTOs cancelarCita(citaDTOs citaCancelar) throws PersistenciaException {
        Cita citaBuscar=null;
        try {     
                if (citaCancelar.getEstado()) {

                    Bson filtroCombinado = Filters.and(
                        Filters.eq("fechaHora", citaCancelar.getFechaHora()), 
                        Filters.eq("cedulaProfesional", citaCancelar.getCedulaProfesional())
                    );
                    citaBuscar = this.coleccion.find(filtroCombinado).first();

                    if (citaBuscar != null) {
                        Bson updateOperation = Updates.set("estado", false);
                        this.coleccion.updateOne(Filters.eq("_id", citaBuscar.getId()), updateOperation);
                        citaBuscar = this.coleccion.find(Filters.eq("_id", citaBuscar.getId())).first();
                    } else {
                        throw new PersistenciaException("No se encontró la cita para cancelar");
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al eliminar cita");
            throw new PersistenciaException("No se pudo eliminar la cita"+e);
        }
        return cc.convertirMapeoAEntidad(citaBuscar);
    }
    
    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasignar Cita original a reasignar.
     * @param nueva Nueva cita con los detalles de reasignación.
     * @return Cita reasignada.
     * @throws PersistenciaException Si ocurre un error durante la reasignación.
     */
    @Override
    public citaDTOs ReasignarCita(citaDTOs citaReasignar,citaDTOs nueva) throws PersistenciaException {
        
        Cita citaBuscar=null;
        try {           
            if (citaReasignar.getEstado()) {
                Bson filtroCombinado = Filters.and(
                    Filters.eq("fechaHora", citaReasignar.getFechaHora()),
                    Filters.eq("cedulaProfesional", citaReasignar.getCedulaProfesional())
                );
                citaBuscar = this.coleccion.find(filtroCombinado).first();

                if (citaBuscar != null) {
                    Bson filtroActualizar = Filters.eq("_id", citaBuscar.getId());
                    Bson actualizacion = Updates.combine(
                        Updates.set("fechaHora", nueva.getFechaHora()),
                        Updates.set("estado", nueva.getEstado())  // Asegúrate de que el nuevo estado se pase correctamente
                    );
                    this.coleccion.updateOne(filtroActualizar, actualizacion);
                    citaBuscar = this.coleccion.find(Filters.eq("_id", citaBuscar.getId())).first();
                } else {
                    throw new PersistenciaException("No se encontró la cita a reasignar.");
                }
            } else {
                throw new PersistenciaException("La cita no está en estado activo y no puede ser reasignada.");
            }    
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al reasignar cita ");
            throw new PersistenciaException("No se pudo reasignar ");
        }
        return cc.convertirMapeoAEntidad(citaBuscar);
    }
    
    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param citaVerifica Cita con la fecha a verificar.
     * @return Cita confirmada si la fecha está disponible.
     * @throws PersistenciaException Si ocurre un error en la verificación.
     */
    @Override
    public citaDTOs verificaFecha(citaDTOs citaVerifica) throws PersistenciaException {
        Cita existente=null;
        try {
            Bson filtroCombinado = Filters.and(
                Filters.eq("fechaHora", citaVerifica.getFechaHora()), 
                Filters.eq("cedulaProfesional", citaVerifica.getCedulaProfesional()),
                Filters.eq("estado",citaVerifica.getEstado())
            );
            existente = this.coleccion.find(filtroCombinado).first();
            
            return cc.convertirMapeoAEntidad(existente);
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al verificar la disponibilidad de la cita");
            throw new PersistenciaException("Error al verificar");
        }
    }    
    
    /**
     * Obtiene el inicio del día para una fecha dada.
     * 
     * @param date Fecha para calcular el inicio del día.
     * @return Calendar configurado al inicio del día de la fecha dada.
     * @throws PersistenciaException Si ocurre un error al calcular.
     */
    @Override
    public Calendar getStartOfDay(Date date) throws PersistenciaException {
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
    @Override
    public Calendar getEndOfDay(Date date) throws PersistenciaException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }
    
    /**
     * Método de insercion para pruevas
     */
    @Override
    public void inserccionMoco(){
             
           try {  
             String cedulaComun = "CED123456789";
            Bson filtroCedula = Filters.eq("cedulaProfesional", cedulaComun);
            long count = this.coleccion.countDocuments(filtroCedula);
            if (count == 0) {
                List<Cita> citasInsertadas = new ArrayList<>();
                List<ObjectId> citasIds = new ArrayList<>();
                List<Paciente> pacientesInsertados = new ArrayList<>();

                // Insertar pacientes
                String[] nombres = {"Elena", "Carlos", "Ana"};
                String[] apellidosPaterno = {"Rodriguez", "Fernandez", "Martinez"};
                String[] apellidosMaterno = {"Gomez", "Diaz", "Lopez"};
                String[] telefonos = {"5544332211", "5522113344", "5566778899"};
                String[] correos = {"elena.rodriguez@example.com", "carlos.fernandez@example.com", "ana.martinez@example.com"};

                for (int i = 0; i < 3; i++) {
                    ObjectId pacienteId = new ObjectId(); // Generar un nuevo ObjectId para cada paciente
                    Paciente nuevoPaciente = new Paciente(pacienteId, nombres[i], apellidosPaterno[i], apellidosMaterno[i], new Date(), 30 + i, telefonos[i], correos[i]);
                    pacientesInsertados.add(nuevoPaciente);
                    p.getColeccion().insertOne(nuevoPaciente);
                }

                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

                // Insertar 5 citas con diferentes fechas y horas y asignar a cada uno un paciente
                for (int i = 0; i < 5; i++) {
                    GregorianCalendar fechaCalendario = new GregorianCalendar();
    
                    // Añadir días a la fecha actual, uno para cada iteración
                    fechaCalendario.add(GregorianCalendar.DAY_OF_MONTH, i);

                    // Establecer la hora, los minutos y segundos
                    fechaCalendario.set(GregorianCalendar.HOUR_OF_DAY, 8 + (i % 9));
                    fechaCalendario.set(GregorianCalendar.MINUTE, (i % 2) * 30);
                    fechaCalendario.set(GregorianCalendar.SECOND, 0);
                    fechaCalendario.set(GregorianCalendar.MILLISECOND, 0);

                    // Obtener la fecha y hora del calendario como un objeto Date
                    Date fechaHora = fechaCalendario.getTime();
                    ObjectId pacienteId = pacientesInsertados.get(i % pacientesInsertados.size()).getId(); // Cicla a través de los pacientes para asignar citas
                    Cita nuevaCita = new Cita();
                    nuevaCita.setFechaHora(fechaHora);
                    nuevaCita.setCedulaProfesional(cedulaComun);
                    nuevaCita.setPaciente(pacienteId); // Asignar el ObjectId del paciente a la cita
                    nuevaCita.setObservacion("Consulta general " + (i + 1));
                    nuevaCita.setEstado(true);

                    coleccion.insertOne(nuevaCita);
                    citasInsertadas.add(nuevaCita);
                    ObjectId citaId = nuevaCita.getId();
                    citasIds.add(citaId);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
