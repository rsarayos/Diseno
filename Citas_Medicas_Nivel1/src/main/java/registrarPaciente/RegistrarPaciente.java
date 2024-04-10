package registrarPaciente;

import Entidades.Paciente;
import Persistencia.PacientesDAO;
import dtos.PacienteDTO;

/**
 *
 * @author alex_
 */
public class RegistrarPaciente implements IRegistrarPaciente{
    
    private PacientesDAO pacientes;

    public RegistrarPaciente(PacientesDAO pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public boolean registrarPaciente(PacienteDTO pacienteNuevo) {
        Paciente paciente = new Paciente(
                pacienteNuevo.getNombres(), 
                pacienteNuevo.getApellidoPaterno(), 
                pacienteNuevo.getApellidoMaterno(), 
                pacienteNuevo.getTelefono(), 
                pacienteNuevo.getCorreo());
        
        return this.pacientes.agregarPaciente(paciente);
    }
    
}
