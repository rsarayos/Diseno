package citas_medicas_dao;

import javax.persistence.EntityManager;

/**
 *
 * @author alex_
 */
public interface IConexion {
    
    public EntityManager crearConexion();
    
}
