package negocio_bo;

import citas_medicas_dao.CitaDAO;
import citas_medicas_dao.CitaDAOListas;
import citas_medicas_dao.Conexion;
import citas_medicas_dao.ICitaDAO;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.IPacienteDAO;
import citas_medicas_dao.MedicoDAO;
import citas_medicas_dao.MedicoDAOListas;
import citas_medicas_dao.PacienteDAO;
import citas_medicas_dao.PacienteDAOListas;
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
 * Clase que implementa la lógica de negocio relacionada con las citas médicas.
 * 
 * Esta clase implementa la interfaz ICitaNegocio y proporciona métodos para agendar citas médicas y consultar su disponibilidad.
 * Utiliza instancias de ICitaDAO, IPacienteDAO y IMedicoDAO para interactuar con la capa de persistencia.
 * 
 */
public class CitaNegocio implements ICitaNegocio{
    
    /** Instancia para manejar la conexión con la base de datos. */
    private final IConexion conexion;
    
    /** Instancia para interactuar con la capa de persistencia para las citas médicas. */
    private final ICitaDAO citaDAO;
    
    /** Instancia para interactuar con la capa de persistencia para los pacientes. */
    private final IPacienteDAO pacienteDAO;
    
    /** Instancia para interactuar con la capa de persistencia para los médicos. */
    private final IMedicoDAO medicoDAO;
    
    /** Instancia del convertidor de citas para convertir entre entidades y DTO. */
    private ConvertidorCita convCita;
    
    /** Logger para registrar mensajes de error y depuración. */
    static final Logger logger = Logger.getLogger(CitaNegocio.class.getName());

    /**
     * Constructor de la clase CitaNegocio.
     * 
     * Crea una instancia de CitaNegocio y inicializa las instancias de conexión y los DAO necesarios para interactuar con la capa de persistencia.
     */
    public CitaNegocio() {
        this.conexion = new Conexion();
        this.citaDAO = new CitaDAO(conexion);
        this.pacienteDAO = new PacienteDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
        this.convCita = new ConvertidorCita();
    }

    /**
     * Constructor de la clase CitaNegocio para utilizar con listas.
     * 
     * Crea una instancia de CitaNegocio y inicializa las instancias de conexión y los DAO necesarios para interactuar con la capa de persistencia.
     * @param citaDAO objeto DAO para persistencia en memoria
     * @param pacienteDAO objeto DAO para persistencia en memoria
     * @param medicoDAO objeto DAO para persistencia en memoria
     */
    public CitaNegocio(CitaDAOListas citaDAO, PacienteDAOListas pacienteDAO, MedicoDAOListas medicoDAO) {
        this.conexion = new Conexion();
        this.citaDAO = citaDAO;
        this.pacienteDAO = pacienteDAO;
        this.medicoDAO = medicoDAO;
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
