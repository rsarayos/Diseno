package registrarPaciente;

import dtos.PacienteDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.IPacienteNegocio;
import objetosNegocio.PacienteNegocio;
import excepcionesNegocio.NegocioException;

/**
 * Clase que actúa como controlador para el registro de nuevos pacientes.
 * 
 * Esta clase se encarga de gestionar las operaciones relacionadas con el registro de pacientes,
 * interactuando con la capa de negocio para realizar dichas operaciones.
 * 
 */
public class CRegistrarPaciente {
    
    /** Objeto de negocio que realiza las operaciones relacionadas con los pacientes. */
    private final IPacienteNegocio pacienteBO;
    
    /** Objeto Logger para la gestión de logs. */
    static final Logger logger = Logger.getLogger(CRegistrarPaciente.class.getName());

    /**
     * Constructor de la clase RegistrarPacienteCO.
     * 
     * Inicializa un objeto de la capa de negocio IPacienteNegocio para utilizarlo en las operaciones de registro.
     */
    public CRegistrarPaciente() {
        this.pacienteBO = new PacienteNegocio();
    }
    
    /**
     * Registra un nuevo paciente en el sistema.
     * 
     * @param pacienteNuevo el objeto PacienteDTO que representa al nuevo paciente a registrar.
     * @return un objeto PacienteDTO que representa al paciente recién registrado.
     */
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
