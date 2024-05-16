package dao;

import entidades.Cita;
import entidades.CitaConPaciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author alex_
 */
public interface ICitaConPacienteDAO {
    
    /**
     * Obtiene una lista de citas asociadas a un paciente o criterio específico.
     * 
     * @param cita Objeto Cita con criterios específicos para la búsqueda.
     * @return Lista de objetos Cita que cumplen con los criterios.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<CitaConPaciente> obtenerCitas(Cita cita) throws PersistenciaException;
    
    /**
     * Consulta las citas por el nombre del paciente.
     *
     * @param cedulaMedico Cedula del medico encargado de la cita
     * @param nombrePaciente Nombre del paciente de la cita
     * @return Lista de citas que coinciden con el nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    public List<CitaConPaciente> consultarPorNombre(String cedulaMedico, String nombrePaciente) throws PersistenciaException;

    /**
     * Consulta las citas por fecha.
     * 
     * @param citaFecha Cita con la fecha específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa fecha.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<CitaConPaciente> consultarPorFecha(Cita citaFecha) throws PersistenciaException;

    /**
     * Consulta las citas por hora específica.
     * 
     * @param citaHora Cita con la hora específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa hora.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<CitaConPaciente> consultaPorHora(Cita citaHora) throws PersistenciaException;
    
}
