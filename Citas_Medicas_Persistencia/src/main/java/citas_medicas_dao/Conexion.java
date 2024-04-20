package citas_medicas_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
public class Conexion implements IConexion {

    /**
     * Constructor por defecto de la clase.
     */
    public Conexion() {
    }
    
    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("citasMedicasPU");
        //Solicitamos una entityManager.
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
