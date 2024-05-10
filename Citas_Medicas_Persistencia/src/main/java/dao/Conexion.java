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
 * Clase que implementa la interfaz IConexion para crear conexiones a la base de datos.
 * 
 * Esta clase proporciona una implementación del método crearConexion para obtener
 * una instancia de EntityManager y así interactuar con la base de datos.
 * 
 * Se asume que existe una unidad de persistencia llamada "citasMedicasPU" configurada
 * en el archivo persistence.xml.
 * 
 */
public class Conexion<T> implements IConexion {

    private final String nombreBaseDatos  = ConstantesPersistencia.bases.CITAS_MEDICAS;
    private final String nombreColeccion;
    private final Class<T> tipoBase;
    private final String cadenaConexion  = ConstantesPersistencia.conexiones.CONEXION_MONGO;
    
    /**
     * Constructor por defecto de la clase.
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
