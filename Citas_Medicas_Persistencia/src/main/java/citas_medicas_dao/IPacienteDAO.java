package citas_medicas_dao;

import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author alex_
 */
public interface IPacienteDAO {
    
    public void agregarPacientes() throws PersistenciaException;
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException;
    public List<Paciente> obtenerPacientes() throws PersistenciaException;
    public Paciente obtenerPaciente(Long id) throws PersistenciaException;
    
}
