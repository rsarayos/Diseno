package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * Interfaz para la creación de conexiones a la base de datos.
 * 
 * Esta interfaz define un método para crear y obtener una instancia de
 * EntityManager, que se utiliza para interactuar con la base de datos.
 * 
 */
public interface IConexion {
    
    /**
     * Crea y devuelve una nueva conexión a la base de datos.
     * 
     * @return La nueva conexión a la base de datos en forma de EntityManager.
     */
     public MongoClient obtenerConexion();
     
     public MongoCollection obtenerColeccion(MongoClient cliente);
    
}
