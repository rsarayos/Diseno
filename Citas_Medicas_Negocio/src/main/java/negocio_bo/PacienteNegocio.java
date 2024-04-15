package negocio_bo;

import citas_medicas_dao.Conexion;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IPacienteDAO;
import citas_medicas_dao.PacienteDAO;
import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import convertidores.ConvertidorPaciente;
import dtos.PacienteDTO;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_excepciones.NegocioException;
import negocio_excepciones.ValidacionException;

/**
 *
 * @author alex_
 */
public class PacienteNegocio implements IPacienteNegocio {
    
    private final IConexion conexion;
    private final IPacienteDAO pacienteDAO;
    private ConvertidorPaciente convPaciente;
    static final Logger logger = Logger.getLogger(PacienteNegocio.class.getName());

    public PacienteNegocio() {
        this.conexion = new Conexion();
        this.pacienteDAO = new PacienteDAO(conexion);
        this.convPaciente = new ConvertidorPaciente();
    }
    
    @Override
    public PacienteDTO registrarPaciente(PacienteDTO paciente) throws NegocioException {
        Paciente pacientePersistencia = null;
        try {
            if (paciente.esValido()) {
                try {
                    pacientePersistencia = pacienteDAO.agregarPaciente(convPaciente.convertidorDTOAEntidad(paciente));
                } catch (PersistenciaException ex) {
                    logger.log(Level.SEVERE, "Excepcion en persistencia");
                }
            }
        } catch (ValidacionException ex) {
            logger.log(Level.SEVERE, "Excepcion en validacion");
        }
        return convPaciente.convertidorEntidadaADTOSinCitas(pacientePersistencia);
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
                pacientes.add(convPaciente.convertidorEntidadaADTOConCitas(paciente));
            }
        }
        
        return pacientes;
    }
    
}
