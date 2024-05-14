package objetosNegocio;

import dtos.MedicoDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la lógica de negocio de los médicos.
 * 
 * Proporciona métodos para registrar un nuevo médico y obtener información de un médico existente.
 * 
 */
public interface IMedicoNegocio {
    
    /**
     * Método para registrar un nuevo médico.
     */
    public void registrarMedico();
    
    /**
     * Método para obtener la información de un médico dado su número de cédula profesional.
     * 
     * @param numCedula el número de cédula profesional del médico que se desea obtener.
     * @return un objeto de tipo MedicoDTO que contiene la información del médico.
     */
    public MedicoDTO obtenerMedico(String numCedula);
    
    /**
     * Método para registrar un médico en el sistema.
     *
     * @param medico El objeto DTO del médico a registrar.
     * @return El objeto DTO del médico registrado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * registro.
     */
    public MedicoDTO registrarNuevoMedico(MedicoDTO medico) throws NegocioException;
    
    /**
     * Método para consultar todos los médicos registrados en el sistema.
     *
     * @return Una lista de objetos DTO que representan a los médicos
     * consultados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * consulta.
     */
    public List<MedicoDTO> consultarMedico() throws NegocioException;
    
    /**
     * Método para eliminar un médico del sistema.
     *
     * @param medico El objeto DTO del médico a eliminar.
     * @return El objeto DTO del médico eliminado.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * eliminación.
     */
    public MedicoDTO eliminarMedico(MedicoDTO medico) throws NegocioException;
    
    /**
     * Método para buscar médicos en el sistema según criterios como nombre,
     * cédula y especialidad.
     *
     * @param nombre El nombre del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param cedula La cédula del médico a buscar (puede ser null o vacío para
     * no considerar este criterio).
     * @param especialidad La especialidad del médico a buscar (puede ser null o
     * vacío para no considerar este criterio).
     * @return Una lista de objetos DTO que representan a los médicos
     * encontrados.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * búsqueda.
     */
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) throws NegocioException;
    
}
