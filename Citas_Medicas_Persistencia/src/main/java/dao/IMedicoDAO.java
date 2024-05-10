package dao;

import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;

/**
 * Interfaz para el acceso a datos de médicos.
 * 
 * Esta interfaz define métodos para agregar médicos a la base de datos
 * y para obtener un médico por su número de cédula profesional.
 * 
 */
public interface IMedicoDAO {
    
    /**
     * Agrega médicos a la base de datos.
     * 
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public void agregarMedicos() throws PersistenciaException;
    
    /**
     * Obtiene un médico por su número de cédula profesional.
     * 
     * @param cedula La cédula profesional del médico que se desea obtener.
     * @return El médico encontrado, o null si no se encontró ningún médico con la cédula especificada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Medico obtenerMedicoCedula(String cedula) throws PersistenciaException;
    
    public Medico agregarDatosFiscales(Medico medico) throws PersistenciaException;
    
}
