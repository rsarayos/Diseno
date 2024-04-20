package negocio_bo;

import citas_medicas_dao.CitaDAO;
import citas_medicas_dao.Conexion;
import citas_medicas_dao.ICitaDAO;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.IPacienteDAO;
import citas_medicas_dao.MedicoDAO;
import citas_medicas_dao.PacienteDAO;
import citas_medicas_entidades.Cita;
import citas_medicas_entidades.Medico;
import citas_medicas_entidades.Paciente;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import convertidores.ConvertidorCita;
import dtos.CitaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_excepciones.NegocioException;
import negocio_excepciones.ValidacionException;

/**
 *
 * @author alex_
 */
public class CitaNegocio implements ICitaNegocio{
    
    private final IConexion conexion;
    private final ICitaDAO citaDAO;
    private final IPacienteDAO pacienteDAO;
    private final IMedicoDAO medicoDAO;
    private ConvertidorCita convCita;
    static final Logger logger = Logger.getLogger(CitaNegocio.class.getName());

    public CitaNegocio() {
        this.conexion = new Conexion();
        this.citaDAO = new CitaDAO(conexion);
        this.pacienteDAO = new PacienteDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
        this.convCita = new ConvertidorCita();
    }

    @Override
    public CitaDTO agendarCita(CitaDTO cita) throws NegocioException {
        Cita citaPersistencia = null;
        try {
            try {
                if (cita.esValido()) {
                    Paciente paciente = pacienteDAO.obtenerPaciente(cita.getPaciente().getId());
                    Medico medico = medicoDAO.obtenerMedicoCedula(cita.getMedico().getCedulaProfesional());
                    Cita citaNueva = new Cita(
                            cita.getFechaHora(),
                            medico,
                            paciente,
                            cita.getObservaciones(),
                            cita.getEstado()
                    );
                    try {
                        citaPersistencia = citaDAO.agregarCita(citaNueva);
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            return convCita.convertidorEntidadaADTO(citaPersistencia);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "No se pudo registrar la cita", ex);
            throw new NegocioException("Error al registrar la cita", ex);
        }
    }

    @Override
    public CitaDTO consultarDisponibilidad(CitaDTO cita) throws NegocioException {
        Cita citaPersistencia = null;
        try {
            try {
                if (cita.esValido()) {
                    Medico medico = medicoDAO.obtenerMedicoCedula(cita.getMedico().getCedulaProfesional());
                    try {
                        citaPersistencia = citaDAO.consultarConFecha(cita.getFechaHora(), medico);
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            if (citaPersistencia != null) {
                return convCita.convertidorEntidadaADTO(citaPersistencia);
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "No se pudo buscar la cita", ex);
            throw new NegocioException("Error al buscar la cita", ex);
        }
    }
    
}
