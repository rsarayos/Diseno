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
public class ConsultarPacienteCO {
    
    private final IPacienteNegocio pacienteBO;
    static final Logger logger = Logger.getLogger(ConsultarPacienteCO.class.getName());

    public ConsultarPacienteCO() {
        this.pacienteBO = new PacienteNegocio();
    }
    
    protected List<PacienteDTO> consultarPacientes() {
        
        List<PacienteDTO> listaPacientes = new ArrayList<>();
        
        try {
            listaPacientes = pacienteBO.obtenerPacientes();
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error en negocio al obtener los pacientes");
        }
        
        return listaPacientes;
    }
    
}
