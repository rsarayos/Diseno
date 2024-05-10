package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author alex_
 */
public class ObtenerColeccion<T> {
    private final String nombreBaseDatos  = "citas_medicas";
    private final String nombreColeccion;
    private final Class<T> tipoBase;

    public ObtenerColeccion(String nombreColeccion, Class<T> tipoBase) {
        this.nombreColeccion = nombreColeccion;
        this.tipoBase = tipoBase;
    }
    
    public MongoCollection obtenerColeccion(MongoClient cliente) {
        
        MongoDatabase baseDatos = cliente.getDatabase(nombreBaseDatos);
        MongoCollection<T> coleccion = baseDatos.getCollection(nombreColeccion, tipoBase);

        return coleccion;
    }
    
}
