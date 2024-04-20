package registrarPaciente;

import dtos.PacienteDTO;

/**
 * Interfaz que define el contrato para registrar nuevos pacientes.
 * 
 * Esta interfaz proporciona un método para registrar un nuevo paciente
 * en el sistema de gestión médica.
 * 
 */
public interface IRegistrarPaciente {
    
    /**
     * Registra un nuevo paciente en el sistema.
     * 
     * @param pacienteNuevo el objeto PacienteDTO que representa al nuevo paciente a registrar.
     * @return un objeto PacienteDTO que representa al paciente recién registrado.
     */
    public PacienteDTO registrarPaciente(PacienteDTO pacienteNuevo);
    
}
