/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Entidades.Cita;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase interfaz para la citaDAO
 * @author JESUS
 */
public interface ICitaDAO {
    
    /**
     * Obtiene una lista de citas asociadas a un paciente o criterio específico.
     * 
     * @param citas Objeto Cita con criterios específicos para la búsqueda.
     * @return Lista de objetos Cita que cumplen con los criterios.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<Cita> obtenerCitas(Cita citas) throws PersistenciaException;

    /**
     * Consulta las citas por el nombre del paciente.
     * 
     * @param citaNombre Cita con el nombre del paciente como criterio de búsqueda.
     * @return Lista de citas que coinciden con el nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<Cita> consultarPorNombre(Cita citaNombre) throws PersistenciaException;

    /**
     * Consulta las citas por fecha.
     * 
     * @param citaFecha Cita con la fecha específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa fecha.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<Cita> consularPorFecha(Cita citaFecha) throws PersistenciaException;

    /**
     * Consulta las citas por hora específica.
     * 
     * @param citaHora Cita con la hora específica como criterio de búsqueda.
     * @return Lista de citas programadas para esa hora.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia.
     */
    public List<Cita> consultaPorHora(Cita citaHora) throws PersistenciaException;

    /**
     * Cancela una cita existente.
     * 
     * @param citaCancelar Cita a cancelar.
     * @return Cita cancelada.
     * @throws PersistenciaException Si ocurre un error durante la cancelación.
     */
    public Cita cancelarCita(Cita citaCancelar) throws PersistenciaException;

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasignar Cita original a reasignar.
     * @param nueva Nueva cita con los detalles de reasignación.
     * @return Cita reasignada.
     * @throws PersistenciaException Si ocurre un error durante la reasignación.
     */
    public Cita ReasignarCita(Cita citaReasignar, Cita nueva) throws PersistenciaException;

    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param citaVerifica Cita con la fecha a verificar.
     * @return Cita confirmada si la fecha está disponible.
     * @throws PersistenciaException Si ocurre un error en la verificación.
     */
    public Cita verificaFecha(Cita citaVerifica) throws PersistenciaException;

    /**
     * Obtiene el inicio del día para una fecha dada.
     * 
     * @param date Fecha para calcular el inicio del día.
     * @return Calendar configurado al inicio del día de la fecha dada.
     * @throws PersistenciaException Si ocurre un error al calcular.
     */
    public Calendar getStartOfDay(Date date) throws PersistenciaException;

    /**
     * Obtiene el fin del día para una fecha dada.
     * 
     * @param date Fecha para calcular el fin del día.
     * @return Calendar configurado al final del día de la fecha dada.
     * @throws PersistenciaException Si ocurre un error al calcular.
     */
    public Calendar getEndOfDay(Date date) throws PersistenciaException;

    /**
     * Método de insercion para pruevas
     */
    public void inserccionMoco();
}
