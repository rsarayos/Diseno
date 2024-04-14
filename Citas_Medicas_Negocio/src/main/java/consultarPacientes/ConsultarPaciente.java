package consultarPacientes;

import Entidades.Paciente;
import Persistencia.PacientesDAO;
import dtos.PacienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex_
 */
public class ConsultarPaciente implements IConsultarPaciente{
    
    private PacientesDAO pacientes;

    public ConsultarPaciente() {
        this.pacientes = new PacientesDAO();
    }

    @Override
    public List<PacienteDTO> consultarPacientes() {
        
        List<PacienteDTO> listaPacientes = new ArrayList<>();
        
        for (Paciente pa : this.pacientes.getPacientes()) {
            listaPacientes.add(new PacienteDTO(
                    pa.getNombres(), 
                    pa.getApellidoPaterno(), 
                    pa.getApellidoMaterno(), 
                    pa.getTelefono(), 
                    pa.getCorreo()));
        }
        
        return listaPacientes;
        
    }

    public PacientesDAO getPacientes() {
        return pacientes;
    }
    
}
