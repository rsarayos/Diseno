package objetosNegocio;

import dao.CitaDAO;
import dao.Conexion;
import dao.ICitaDAO;
import dao.IConexion;
import dao.IMedicoDAO;
import dao.IPacienteDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import excepcionesPersistencia.PersistenciaException;
import convertidores.ConvertidorCita;
import dao.ConstantesPersistencia;
import dtos.CitaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import excepcionesNegocio.NegocioException;
import excepcionesNegocio.ValidacionException;
import java.util.Calendar;

/**
 * Clase que implementa la lógica de negocio relacionada con las citas médicas.
 * 
 * Esta clase implementa la interfaz ICitaNegocio y proporciona métodos para agendar citas médicas y consultar su disponibilidad.
 * Utiliza instancias de ICitaDAO, IPacienteDAO y IMedicoDAO para interactuar con la capa de persistencia.
 * 
 */
public class CitaNegocio implements ICitaNegocio{
    
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
        this.citaDAO = new CitaDAO(new Conexion(ConstantesPersistencia.colecciones.CITAS, Cita.class));
        this.pacienteDAO = new PacienteDAO(new Conexion(ConstantesPersistencia.colecciones.PACIENTES, Paciente.class));
        this.medicoDAO = new MedicoDAO(new Conexion(ConstantesPersistencia.colecciones.MEDICOS, Medico.class));
        this.convCita = new ConvertidorCita();
    }

    @Override
    public CitaDTO agendarCita(CitaDTO cita) throws NegocioException {
        Cita citaPersistencia = null;
        try {
            try {
                if (cita.esValido()) {
                    Cita citaP = convCita.DTOAEntidad(cita);
                    Paciente paciente = pacienteDAO.obtenerPaciente(citaP.getIdPaciente());
                    Medico medico = medicoDAO.obtenerMedicoCedula(cita.getCedulaMedico());
                    Cita citaNueva = new Cita(
                            cita.getFechaHora(),
                            medico.getCedulaProfesional(),
                            paciente.getId(),
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
            return convCita.EntidadaADTO(citaPersistencia);
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
                    Medico medico = medicoDAO.obtenerMedicoCedula(cita.getCedulaMedico());
                    Calendar fecha = Calendar.getInstance();
                    fecha.setTime(cita.getFechaHora());
                    try {
                        citaPersistencia = citaDAO.consultarConFecha(fecha, medico);
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            if (citaPersistencia != null) {
                return convCita.EntidadaADTO(citaPersistencia);
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "No se pudo buscar la cita", ex);
            throw new NegocioException("Error al buscar la cita", ex);
        }
    }
    
}
