package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Interfaz para la creación de conexiones a la base de datos.
 * 
 * Esta clase implementa la interfaz IConexion para crear y obtener una instancia de
 * MongoClient, que se utiliza para interactuar con la base de datos.
 * 
 * @param <T> clase relacionada a la coleccion a mapear
 */
public class Conexion<T> implements IConexion {

    /**
     * Nombre de la base de datos.
     */
    private final String nombreBaseDatos  = ConstantesPersistencia.bases.CITAS_MEDICAS;
    
    /**
     * Nombre de la coleccion.
     */
    private final String nombreColeccion;
    
    /**
     * Clase relacionada a la coleccion.
     */
    private final Class<T> tipoBase;
    
    /**
     * cadena con la conexion.
     */
    private final String cadenaConexion  = ConstantesPersistencia.conexiones.CONEXION_MONGO;
    
    /**
     * Constructor por defecto de la clase.
     * @param nombreColeccion Nombre de la coleccion a obtener con la conexion
     * @param tipoBase Clase relacionada a la coleccion para mapear
     */
    public Conexion(String nombreColeccion, Class<T> tipoBase) {
        this.nombreColeccion = nombreColeccion;
        this.tipoBase = tipoBase;
    }

    @Override
    public MongoClient obtenerConexion() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry).applyConnectionString(new ConnectionString(cadenaConexion))
                .build();
        return MongoClients.create(settings);
    }

    @Override
    public MongoCollection obtenerColeccion(MongoClient cliente) {
        MongoDatabase baseDatos = cliente.getDatabase(nombreBaseDatos);
        return baseDatos.getCollection(nombreColeccion, tipoBase);
    }
    
}
