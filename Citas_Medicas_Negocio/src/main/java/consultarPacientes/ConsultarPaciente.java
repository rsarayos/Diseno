package consultarPacientes;

import dtos.PacienteDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_bo.IPacienteNegocio;
import negocio_bo.PacienteNegocio;
import negocio_excepciones.NegocioException;

/**
 *
 * @author alex_
 */
public class ConsultarPaciente implements IConsultarPaciente{
    
    private final IPacienteNegocio pacienteBO;
    static final Logger logger = Logger.getLogger(ConsultarPaciente.class.getName());

    public ConsultarPaciente() {
        pacienteBO = new PacienteNegocio();
    }

    @Override
    public List<PacienteDTO> consultarPacientes() {
        
        List<PacienteDTO> listaPacientes = new ArrayList<>();
        
        try {
            listaPacientes = pacienteBO.obtenerPacientes();
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error en negocio al obtener los pacientes");
        }
        
        return listaPacientes;
    }
    
}
