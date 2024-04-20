package citas_medicas_dao;

import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz para el acceso a datos de pacientes.
 * 
 * Esta interfaz define métodos para agregar pacientes a la base de datos,
 * obtener la lista de todos los pacientes, y obtener un paciente por su ID.
 * 
 */
public interface IPacienteDAO {
    
    /**
     * Agrega pacientes a la base de datos.
     * 
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public void agregarPacientes() throws PersistenciaException;
    
    /**
     * Agrega un nuevo paciente a la base de datos.
     * 
     * @param paciente El paciente que se desea agregar.
     * @return El paciente agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;
    
    /**
     * Obtiene la lista de todos los pacientes almacenados en la base de datos.
     * 
     * @return La lista de todos los pacientes.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Paciente> obtenerPacientes() throws PersistenciaException;
    
    /**
     * Obtiene un paciente por su ID.
     * 
     * @param id El ID del paciente que se desea obtener.
     * @return El paciente encontrado, o null si no se encontró ningún paciente con el ID especificado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Paciente obtenerPaciente(Long id) throws PersistenciaException;
    
}
