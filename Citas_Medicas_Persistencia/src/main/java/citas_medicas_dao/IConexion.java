package citas_medicas_dao;

import javax.persistence.EntityManager;

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
    public EntityManager crearConexion();
    
}
