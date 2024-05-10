package pruebasPersistencia;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import dao.Conexion;
import dao.IConexion;
import entidades.Cita;
import entidades.DatosFiscales;
import entidades.Medico;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author alex_
 */
public class pruebasMongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Date fechaActual = new Date();
//        
//        
//        
//        Paciente paciente1 = new Paciente("Ricardo", "Gomez", "Valenzuela", fechaActual, 20, "6455332211", "ricardo@correo.com");
//        
//        DatosFiscales datos = new DatosFiscales("Juan Lopez Gomez", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba", "prueba");
//        
//        List<DatosFiscales> datosFiscales = new LinkedList<>();
//        
//        datosFiscales.add(datos);
//        
//        Medico medico1 = new Medico("12345678", "Juan", "Lopez", "Gomez", fechaActual, "Pediatría", "ABCR123456", "5551234567", "juan@example.com", "Contra", datosFiscales);
//        
//        IConexion conexionMedico = new Conexion("medicos", Medico.class);
//        
////        IConexion conexionPaciente = new Conexion("pacientes", Paciente.class);
////        
////        IConexion conexionCita = new Conexion("citas", Cita.class);
//        
//        MongoCollection coleccionMedicos = conexionMedico.obtenerColeccion();
//        
////        coleccionMedicos.insertOne(medico1);
////        
////        conexionMedico.cerrarConexion();
//        
////        MongoCollection coleccionPacientes = conexionPaciente.obtenerColeccion();
////        
////        MongoCollection coleccionCitas = conexionCita.obtenerColeccion();
////        
////        List<Paciente> pacientes = new ArrayList<>();
////        
////        FindIterable<Paciente> cursor = coleccionPacientes.find();
////        
////        MongoCursor<Paciente> iterator = cursor.iterator();
////        while (iterator.hasNext()) {
////            pacientes.add(iterator.next());
////        }
////        
////        Cita cita = new Cita(fechaActual, "12345678", pacientes.get(0).getId(), "chequeo", Boolean.FALSE);
////        
////        coleccionCitas.insertOne(cita);
//        
//        Medico medico = (Medico) coleccionMedicos.find(eq("cedulaProfesional", "12345678")).first();
//
//        conexionMedico.cerrarConexion();
//        
//        System.out.println(medico);
    }
    
}
