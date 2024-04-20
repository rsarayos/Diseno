package registrarPaciente;

import dtos.PacienteDTO;

/**
 *
 * @author alex_
 */
public class RegistrarPaciente implements IRegistrarPaciente{
    
    private final RegistrarPacienteCO control;

    public RegistrarPaciente() {
        control = new RegistrarPacienteCO();
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO pacienteNuevo) {

        return control.registrarPaciente(pacienteNuevo);
        
    }
    
}
