package citas_medicas_dao;

import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;

/**
 *
 * @author alex_
 */
public interface IMedicoDAO {
    
    public void agregarMedicos() throws PersistenciaException;
    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException;
    
}
