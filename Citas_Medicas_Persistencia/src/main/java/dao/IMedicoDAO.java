package dao;

import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.List;

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
    
    /**
     * Agrega datos fiscales a un médico en la base de datos.
     * 
     * @param medico El médico al que se le agregarán los datos fiscales.
     * @return El médico con los datos fiscales agregados.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Medico agregarDatosFiscales(Medico medico) throws PersistenciaException;
    
    /**
     * Método para registrar un médico en la base de datos.
     *
     * @param medico El objeto de tipo Medico a registrar.
     * @return El objeto Medico registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * registro.
     */
    public Medico registrarMedico(Medico medico) throws PersistenciaException;
    
    /**
     * Método para consultar todos los médicos registrados en la base de datos.
     *
     * @return Una lista de objetos de tipo Medico que representan a los médicos
     * consultados.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * consulta.
     */
    public List<Medico> consultarMedicos() throws PersistenciaException;
    
    /**
     * Método para eliminar un médico de la base de datos.
     *
     * @param medico El objeto de tipo Medico a eliminar.
     * @return El objeto Medico eliminado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * eliminación.
     */
    public Medico eliminarMedico(Medico medico) throws PersistenciaException;
    
    /**
     * Método para buscar médicos en la base de datos según criterios como
     * nombre, cédula y especialidad.
     *
     * @param nombre El nombre del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param cedula La cédula del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param especialidad La especialidad del médico a buscar (puede ser null o
     * vacío para no considerar este criterio).
     * @return Una lista de objetos de tipo Medico que representan a los médicos
     * encontrados.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * búsqueda.
     */
    public List<Medico> buscarMedico(String nombre, String cedula, String especialidad) throws PersistenciaException;
    
}
