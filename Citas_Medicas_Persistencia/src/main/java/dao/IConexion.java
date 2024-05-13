package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * Interfaz para la creación de conexiones a la base de datos.
 * 
 * Esta interfaz define un método para crear y obtener una instancia de
 * MongoClient, que se utiliza para interactuar con la base de datos.
 * 
 */
public interface IConexion {
    
    /**
     * Método para obtener una conexión a MongoDB.
     *
     * @return Cliente MongoClient que representa la conexión a MongoDB.
     */
     public MongoClient obtenerConexion();
     
     /**
     * Método para obtener una colección específica utilizando un cliente MongoClient.
     *
     * @param cliente Cliente MongoClient previamente establecido.
     * @return Colección MongoCollection que representa una colección en MongoDB.
     */
     public MongoCollection obtenerColeccion(MongoClient cliente);
    
}
