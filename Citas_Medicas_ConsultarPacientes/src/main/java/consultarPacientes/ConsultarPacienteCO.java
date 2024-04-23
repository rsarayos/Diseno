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
 * Clase que proporciona la lógica de negocio para consultar pacientes.
 * 
 * Esta clase utiliza la interfaz IPacienteNegocio para interactuar con la capa de negocio
 * y obtener la lista de pacientes registrados.
 * 
 */
public class ConsultarPacienteCO {
    
    /** Objeto que proporciona acceso a las operaciones de negocio relacionadas con los pacientes. */
    private final IPacienteNegocio pacienteBO;
    
    /** Logger utilizado para registrar eventos y errores durante la consulta de pacientes. */
    static final Logger logger = Logger.getLogger(ConsultarPacienteCO.class.getName());

    /**
     * Constructor de la clase ConsultarPacienteCO.
     * Inicializa el objeto pacienteBO utilizando la implementación concreta de PacienteNegocio.
     */
    public ConsultarPacienteCO() {
        this.pacienteBO = new PacienteNegocio();
    }
    
    /**
     * Método protegido para consultar la lista de pacientes.
     * 
     * @return una lista de objetos PacienteDTO que representan los pacientes registrados.
     */
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
