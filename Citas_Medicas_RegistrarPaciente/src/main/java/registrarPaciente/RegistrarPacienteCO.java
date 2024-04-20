package registrarPaciente;

import dtos.PacienteDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_bo.IPacienteNegocio;
import negocio_bo.PacienteNegocio;
import negocio_excepciones.NegocioException;

/**
 *
 * @author alex_
 */
public class RegistrarPacienteCO {
    
    private final IPacienteNegocio pacienteBO;
    static final Logger logger = Logger.getLogger(RegistrarPaciente.class.getName());

    public RegistrarPacienteCO() {
        this.pacienteBO = new PacienteNegocio();
    }
    
    protected PacienteDTO registrarPaciente(PacienteDTO pacienteNuevo) {
        PacienteDTO paciente = null;
        try {
            paciente = pacienteBO.registrarPaciente(pacienteNuevo);
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error en negocio al registrar al paciente");
        }

        return paciente;
    }
    
}
