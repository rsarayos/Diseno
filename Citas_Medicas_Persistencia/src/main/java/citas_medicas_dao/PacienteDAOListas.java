package citas_medicas_dao;

import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz IPacienteDAO que utiliza una lista en memoria para almacenar los pacientes.
 */
public class PacienteDAOListas implements IPacienteDAO {

    /**
     * Lista que almacena los pacientes
     */
    private List<Paciente> pacientes;

    /**
     * Número de identificación para los pacientes
     */
    private Long numPaciente;

    /**
     * Constructor de la clase PacienteDAOListas.
     * Inicializa la lista de pacientes y el número de paciente.
     */
    public PacienteDAOListas() {
        this.pacientes = new ArrayList<>(); 
        this.numPaciente = 1L;
    }
    
    @Override
    public void agregarPacientes() throws PersistenciaException {
        
    }

    @Override
    public Paciente agregarPaciente(Paciente paciente) throws PersistenciaException {
        paciente.setId(numPaciente);
        if (this.pacientes.add(paciente)) {
            numPaciente++;
            return paciente;
        } else {
            throw new PersistenciaException("No se pude agregar al paciente");
        }
    }

    @Override
    public List<Paciente> obtenerPacientes() throws PersistenciaException {
        return pacientes;
    }

    @Override
    public Paciente obtenerPaciente(Long id) throws PersistenciaException {
        if (this.pacientes.isEmpty()) {
            return null;
        } else {
            for (Paciente p : pacientes) {
                if (p.getId().equals(id)) {
                    return p;
                }
            }
        }
        return null;
    }
    
}
