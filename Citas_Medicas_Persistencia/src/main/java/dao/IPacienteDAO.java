package dao;

import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz para el acceso a datos de pacientes.
 * 
 * Esta interfaz define métodos para agregar pacientes a la base de datos,
 * obtener la lista de todos los pacientes, y obtener un paciente por su ID.
 * 
 */
public interface IPacienteDAO {
    
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
    public Paciente obtenerPaciente(ObjectId id) throws PersistenciaException;
    
    public Paciente agregarDatosFiscales(Paciente paciente) throws PersistenciaException;
    
}
