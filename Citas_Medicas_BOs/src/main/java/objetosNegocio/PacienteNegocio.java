package objetosNegocio;

import dao.Conexion;
import dao.IConexion;
import dao.IPacienteDAO;
import dao.PacienteDAO;
import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import convertidores.ConvertidorPaciente;
import dao.ConstantesPersistencia;
import dtos.PacienteDTO;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import excepcionesNegocio.NegocioException;
import excepcionesNegocio.ValidacionException;

/**
 * Clase que implementa la lógica de negocio relacionada con los pacientes.
 * 
 * Proporciona métodos para registrar nuevos pacientes y obtener la lista de pacientes registrados.
 * 
 */
public class PacienteNegocio implements IPacienteNegocio {
    
    /** Objeto para interactuar con la capa de acceso a datos de los pacientes. */
    private final IPacienteDAO pacienteDAO;
    
    /** Objeto para convertir entre DTO y entidad de paciente. */
    private ConvertidorPaciente convPaciente;
    
    /** Logger para registrar mensajes de registro. */
    static final Logger logger = Logger.getLogger(PacienteNegocio.class.getName());

    /**
     * Constructor de la clase PacienteNegocio.
     * 
     * Inicializa los objetos necesarios para la lógica de negocio de los pacientes.
     */
    public PacienteNegocio() {
        this.pacienteDAO = new PacienteDAO(new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class));
        this.convPaciente = new ConvertidorPaciente();
    }
    
    @Override
    public PacienteDTO registrarPaciente(PacienteDTO paciente) throws NegocioException {
        Paciente pacientePersistencia = null;
        try {
            if (paciente.esValido()) {
                    try {
                        pacientePersistencia = pacienteDAO.agregarPaciente(convPaciente.DTOAEntidad(paciente));
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
            } else {
                return null;
            }
        } catch (ValidacionException ex) {
            logger.log(Level.SEVERE, "Excepcion en validacion");
        }
        return convPaciente.EntidadaADTO(pacientePersistencia);
    }
    
    @Override
    public PacienteDTO buscarPacienteTelefono(String telefono) throws NegocioException {
        Paciente pacienteEncontrado = null;
        
        try {
            pacienteEncontrado = pacienteDAO.obtenerPacienteTelefono(telefono);
            
            return convPaciente.EntidadaADTO(pacienteEncontrado);
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(PacienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return convPaciente.EntidadaADTO(pacienteEncontrado);
    }

    @Override
    public List<PacienteDTO> obtenerPacientes() throws NegocioException {
        List<Paciente> pacientesPersistencia = null;
        List<PacienteDTO> pacientes = new LinkedList<>();
        try {
            pacientesPersistencia = pacienteDAO.obtenerPacientes();
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error en persistencia al obtener pacientes");
            throw new NegocioException("Error al obtener los pacientes", ex);
        }
        if (pacientesPersistencia != null) {
            for (Paciente paciente : pacientesPersistencia) {
                pacientes.add(convPaciente.EntidadaADTO(paciente));
            }
        }
        
        return pacientes;
    }
    
}
