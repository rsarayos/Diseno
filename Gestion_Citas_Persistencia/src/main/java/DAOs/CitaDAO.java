/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import excepciones.PersistenciaException;
import interfaces.ICitaDAO;
import Entidades.Cita;
import Entidades.Paciente;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import java.util.List;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
    
    /**
     * Metodo para conectar a la base de datos y la coleccion
     */
    public CitaDAO(){
        this.coleccion=conexion.ConexionBD.getDatabase().getCollection("citas",Cita.class);
        p=new PacienteDAO();
    }
    
    /**
     * Obtiene una lista de citas asociadas a un paciente o criterio específico.
     * 
     * @param cita Objeto Cita con criterios específicos para la búsqueda.
     * @return Lista de objetos Cita que cumplen con los criterios.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    @Override
    public List<Cita> obtenerCitas(Cita cita) throws PersistenciaException {
        try {
            List<Cita> citas=new ArrayList<>();
            this.coleccion.find(Filters.eq("cedulaProfesional",cita.getCedulaProfesional())).into(citas);
            return citas;
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al consultar citas");
            throw new PersistenciaException("No se pudo obtener todas las citas");
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
    public List<Cita> consultarPorNombre(Cita citaNombre) throws PersistenciaException {
        try {
            List<Cita> citas=new ArrayList<>();
            Bson filtroCedula = Filters.eq("cedulaProfesional", citaNombre.getCedulaProfesional());
            Bson filtroNombre = Filters.eq("paciente.nombre", citaNombre.getPaciente().getNombre());
            Bson filtroCombinado = Filters.and(filtroCedula, filtroNombre);

            this.coleccion.find(filtroCombinado).into(citas);
            
            return citas;
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
    public List<Cita> consularPorFecha(Cita citaFecha) throws PersistenciaException {
            List<Cita> citas=new ArrayList<>();
            Calendar fechaInicio=getStartOfDay(citaFecha.getFechaHora());
            Calendar fechaFinal=getEndOfDay(citaFecha.getFechaHora());
            
        try {   
            Bson filtroCedula=Filters.eq("cedulaProfesional",citaFecha.getCedulaProfesional());
            Bson filtroFecha=Filters.and(Filters.gte("fechaHora", fechaInicio.getTime()),Filters.lte("fechaHora", fechaFinal.getTime()));
        
            Bson filtroCombinado=Filters.and(filtroCedula,filtroFecha);
            
            this.coleccion.find(filtroCombinado).into(citas);
            return citas;
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
    public List<Cita> consultaPorHora(Cita citaHora) throws PersistenciaException {
        try {
            List<Cita> citas = new ArrayList<>();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(citaHora.getFechaHora());
            int hora = calendar.get(Calendar.HOUR_OF_DAY);
            int minuto = calendar.get(Calendar.MINUTE);
            
            List<Bson> pipeline = Arrays.asList(
                Aggregates.project(Projections.fields(
                    Projections.include("cedulaProfesional","fechaHora" ,"observacion", "estado", "paciente", "_id"),
                    Projections.computed("hour", new Document("$hour", new Document("$toDate", "$fechaHora"))),
                    Projections.computed("minute", new Document("$minute", new Document("$toDate", "$fechaHora")))
                )),
                Aggregates.match(Filters.and(
                    Filters.eq("cedulaProfesional", citaHora.getCedulaProfesional()),
                    Filters.eq("hour", hora),
                    Filters.eq("minute", minuto)
                ))
            );

            MongoCollection<Document> collection = this.coleccion.withDocumentClass(Document.class);
            AggregateIterable<Document> result = collection.aggregate(pipeline);
            for (Document doc : result) {
                Cita cita = documentToCita(doc);
                citas.add(cita);
            }

            return citas;

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
    public Cita cancelarCita(Cita citaCancelar) throws PersistenciaException {
        Cita citaBuscar=null;
        try {
            
                if (citaCancelar.isEstado()) {

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
        return citaBuscar;
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
    public Cita ReasignarCita(Cita citaReasignar,Cita nueva) throws PersistenciaException {
        Cita citaBuscar=null;
        try {           
            if (citaReasignar.isEstado()) {
                Bson filtroCombinado=Filters.and(Filters.eq("fechaHora",citaReasignar.getFechaHora()),Filters.eq("cedulaProfesional",citaReasignar.getCedulaProfesional()));
                citaBuscar=this.coleccion.find(filtroCombinado).first();
                if (citaBuscar!=null) {
                    Bson filtroActualizar = Filters.eq("_id", citaBuscar.getId());
                    Bson actualizacion = Updates.set("fechaHora", nueva.getFechaHora());
                    this.coleccion.updateOne(filtroActualizar, actualizacion);
                    citaBuscar=this.coleccion.find(Filters.eq("_id",citaBuscar.getId())).first();
              
                }else{
                    throw new PersistenciaException("No se encontro cita");               
                }
            }          
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error al reasignar cita");
            throw new PersistenciaException("No se pudo reasignar");
        }
        return citaBuscar;
    }
    
    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param citaVerifica Cita con la fecha a verificar.
     * @return Cita confirmada si la fecha está disponible.
     * @throws PersistenciaException Si ocurre un error en la verificación.
     */
    @Override
    public Cita verificaFecha(Cita citaVerifica) throws PersistenciaException {
        Cita existente=null;
        try {
            Bson filtroCombinado = Filters.and(
                Filters.eq("fechaHora", citaVerifica.getFechaHora()), 
                Filters.eq("cedulaProfesional", citaVerifica.getCedulaProfesional()),
                Filters.eq("estado",citaVerifica.isEstado())
            );
            existente = this.coleccion.find(filtroCombinado).first();
            
            return existente;
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
             
          try{  
            String cedulaComun = "CED123456789";
            Bson filtroCedula = Filters.eq("cedulaProfesional", cedulaComun);
            long count = this.coleccion.countDocuments(filtroCedula);
            if (count == 0) {
                List<Cita> citasInsertadas = new ArrayList<>();
                List<ObjectId> citasIds = new ArrayList<>(); // Lista para almacenar los ObjectIds de las citas insertadas
                
                 Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                
                // Insertar 5 citas con diferentes fechas y horas
                for (int i = 0; i < 5; i++) {
                    calendar.setTime(new Date());
                    calendar.add(Calendar.DAY_OF_MONTH, i);

                    calendar.set(Calendar.HOUR_OF_DAY, 8 + (i % 9));
                    calendar.set(Calendar.MINUTE, (i % 2) * 30);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    Date fechaHora = calendar.getTime();
                    Cita nuevaCita = new Cita();
                    nuevaCita.setFechaHora(fechaHora);
                    nuevaCita.setCedulaProfesional(cedulaComun);
                    nuevaCita.setObservacion("Consulta general " + (i + 1));
                    nuevaCita.setEstado(true);

                    coleccion.insertOne(nuevaCita);
                    citasInsertadas.add(nuevaCita);
                    ObjectId citaId = nuevaCita.getId();  // Suponiendo que getId() devuelve el ObjectId de la cita insertada
                    citasIds.add(citaId);  // Agregar el ObjectId a la lista
                }

                // Insertar pacientes y asignar IDs de citas
                String[] nombres = {"Elena", "Carlos", "Ana"};
                String[] apellidosPaterno = {"Rodriguez", "Fernandez", "Martinez"};
                String[] apellidosMaterno = {"Gomez", "Diaz", "Lopez"};
                String[] telefonos = {"5544332211", "5522113344", "5566778899"};
                String[] correos = {"elena.rodriguez@example.com", "carlos.fernandez@example.com", "ana.martinez@example.com"};
                int citasPorPaciente = 2; // Número de citas por paciente

                for (int i = 0, citaIndex = 0; i < 3; i++) {
                    Paciente nuevoPaciente = new Paciente();
                    nuevoPaciente.setNombre(nombres[i]);
                    nuevoPaciente.setApellidoPaterno(apellidosPaterno[i]);
                    nuevoPaciente.setApellidoMaterno(apellidosMaterno[i]);

                    Calendar fechaNacimiento = Calendar.getInstance();
                    fechaNacimiento.set(1990 + i, Calendar.JANUARY, 1);
                    Date fechaNacDate = fechaNacimiento.getTime();

                    nuevoPaciente.setFechaNacimiento(fechaNacDate);
                    nuevoPaciente.setEdad(30 + i);
                    nuevoPaciente.setTelefono(telefonos[i]);
                    nuevoPaciente.setCorreo(correos[i]);

                    List<ObjectId> citasAsignadasIds = new ArrayList<>();
                    for (int j = 0; j < citasPorPaciente && citaIndex < citasInsertadas.size(); j++, citaIndex++) {
                        ObjectId citaId = citasIds.get(citaIndex);
                        citasAsignadasIds.add(citaId);
                        citasInsertadas.get(citaIndex).setPaciente(nuevoPaciente); // Asignar paciente a la cita
                        coleccion.replaceOne(Filters.eq("_id", citaId), citasInsertadas.get(citaIndex)); // Actualizar la cita en la base de datos
                    }
                    nuevoPaciente.setCitas(citasAsignadasIds); // Asignar los IDs de las citas al paciente
                    p.getColeccion().insertOne(nuevoPaciente); // Insertar el paciente
                }
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    /**
     * Método auxiliar para convertir Document a Cita
     * @param doc documento que recibe
     * @return una cita
     */
    private Cita documentToCita(Document doc) {
        Cita cita = new Cita();
        cita.setCedulaProfesional(doc.getString("cedulaProfesional"));
        cita.setEstado(doc.getBoolean("estado"));
        cita.setObservacion(doc.getString("observacion"));
        Date fechaHora = doc.getDate("fechaHora");
        cita.setFechaHora(fechaHora);
        
        // Aquí asumimos que 'paciente' es un subdocumento dentro de la cita
        Document pacienteDoc = (Document) doc.get("paciente");
        if (pacienteDoc != null) {
            Paciente paciente = new Paciente();
            paciente.setNombre(pacienteDoc.getString("nombre"));
            paciente.setApellidoPaterno(pacienteDoc.getString("apellidoPaterno"));
            paciente.setApellidoMaterno(pacienteDoc.getString("apellidoMaterno"));
            paciente.setCorreo(pacienteDoc.getString("correo"));
            paciente.setEdad(pacienteDoc.getInteger("edad", 0)); // Usar un valor predeterminado si no se encuentra
            paciente.setTelefono(pacienteDoc.getString("telefono"));

            // Para convertir la fecha de nacimiento que es un 'Date' a 'LocalDate'
            Date fechaNacimientoDate = pacienteDoc.getDate("fechaNacimiento");
            LocalDate fechaNacimientoLocalDate = fechaNacimientoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date fechaNacimiento = Date.from(fechaNacimientoLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
            paciente.setFechaNacimiento(fechaNacimiento);  // Ahora puedes asignar un Date

            cita.setPaciente(paciente);
        }

        return cita;
    }
    
    
    
}
