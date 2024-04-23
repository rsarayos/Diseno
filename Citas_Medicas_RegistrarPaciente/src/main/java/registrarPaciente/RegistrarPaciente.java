package registrarPaciente;

import dtos.PacienteDTO;

/**
 * Clase que implementa la interfaz IRegistrarPaciente para el registro de nuevos pacientes.
 * 
 * Esta clase actúa como un intermediario entre la capa de presentación y la capa de negocio,
 * manejando la lógica de registro de pacientes.
 * 
 */
public class RegistrarPaciente implements IRegistrarPaciente{
    
    /** Objeto de la clase RegistrarPacienteCO para realizar las operaciones de registro del paciente. */
    private final RegistrarPacienteCO control;

    /**
     * Constructor de la clase RegistrarPaciente.
     * 
     * Inicializa un objeto de la clase RegistrarPacienteCO para utilizarlo en las operaciones de registro.
     */
    public RegistrarPaciente() {
        control = new RegistrarPacienteCO();
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO pacienteNuevo) {

        return control.registrarPaciente(pacienteNuevo);
        
    }
    
}
