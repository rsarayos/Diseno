package citas_medicas_dao;

import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.Calendar;

/**
 *
 * @author alex_
 */
public interface ICitaDAO {
    
    public Cita agregarCita(Cita cita) throws PersistenciaException;
    public Cita consultarConFecha(Calendar fecha, Medico medico) throws PersistenciaException;
    
}
