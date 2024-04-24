package dao;

import entidades.Cita;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.Calendar;

/**
 * Interfaz para el acceso a datos de citas médicas.
 * 
 * Esta interfaz define métodos para agregar una nueva cita médica y para
 * consultar una cita con una fecha específica asociada a un médico.
 * 
 */
public interface ICitaDAO {
    
    /**
     * Agrega una nueva cita médica a la base de datos.
     * 
     * @param cita La cita médica que se desea agregar.
     * @return La cita médica agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cita agregarCita(Cita cita) throws PersistenciaException;
    
    /**
     * Consulta una cita médica con una fecha específica asociada a un médico.
     * 
     * @param fecha La fecha de la cita que se desea consultar.
     * @param medico El médico asociado a la cita.
     * @return La cita médica encontrada, o null si no se encontró ninguna cita con la fecha y el médico especificados.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException;
    
}
