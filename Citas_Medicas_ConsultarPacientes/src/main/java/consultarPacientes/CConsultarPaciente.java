package consultarPacientes;

import dtos.PacienteDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.IPacienteNegocio;
import objetosNegocio.PacienteNegocio;
import excepcionesNegocio.NegocioException;

/**
 * Clase que proporciona la lógica de negocio para consultar pacientes.
 * 
 * Esta clase utiliza la interfaz IPacienteNegocio para interactuar con la capa de negocio
 * y obtener la lista de pacientes registrados.
 * 
 */
public class CConsultarPaciente {
    
    /** Objeto que proporciona acceso a las operaciones de negocio relacionadas con los pacientes. */
    private final IPacienteNegocio pacienteBO;
    
    /** Logger utilizado para registrar eventos y errores durante la consulta de pacientes. */
    static final Logger logger = Logger.getLogger(CConsultarPaciente.class.getName());

    /**
     * Constructor de la clase ConsultarPacienteCO.
     * Inicializa el objeto pacienteBO utilizando la implementación concreta de PacienteNegocio.
     */
    public CConsultarPaciente() {
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
    
    /**
     * Método protegido para consultar un telefono registrado dentro del sistema de pacientes.
     * 
     * @param telefono El telefono a encontrar.
     * @return El paciente encontrado, o null si no se encontro ninguno.
     */
    protected PacienteDTO verificarTelefonoExistente(String telefono){
    
        try {
            return pacienteBO.buscarPacienteTelefono(telefono);
        } catch (NegocioException ex) {
            Logger.getLogger(CConsultarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
