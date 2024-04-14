package citas_medicas_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alex_
 */
public class Conexion implements IConexion {

    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("citasMedicasPU");
        //Solicitamos una entityManager.
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
