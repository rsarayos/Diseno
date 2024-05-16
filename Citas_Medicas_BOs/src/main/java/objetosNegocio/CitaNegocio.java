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
import convertidores.ConvertidorCitaConPaciente;
import dao.CitaConPacienteDAO;
import dao.ConstantesPersistencia;
import dao.ICitaConPacienteDAO;
import dtos.CitaConPacienteDTO;
import dtos.CitaDTO;
import entidades.CitaConPaciente;
import entidadesMapeo.CitaConPacienteMapeo;
import entidadesMapeo.CitaMapeo;
import entidadesMapeo.MedicoMapeo;
import entidadesMapeo.PacienteMapeo;
import java.util.logging.Level;
import java.util.logging.Logger;
import excepcionesNegocio.NegocioException;
import excepcionesNegocio.ValidacionException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio relacionada con las citas médicas.
 * 
 * Esta clase implementa la interfaz ICitaNegocio y proporciona métodos para agendar citas médicas y consultar su disponibilidad.
 * Utiliza instancias de ICitaDAO, IPacienteDAO y IMedicoDAO para interactuar con la capa de persistencia.
 * 
 */
public class CitaNegocio implements ICitaNegocio {

    /**
     * Instancia para interactuar con la capa de persistencia para las citas
     * médicas.
     */
    private final ICitaDAO citaDAO;

    /**
     * Instancia para interactuar con la capa de persistencia para los
     * pacientes.
     */
    private final IPacienteDAO pacienteDAO;

    /**
     * Instancia para interactuar con la capa de persistencia para los médicos.
     */
    private final IMedicoDAO medicoDAO;

    /**
     * Instancia para interactuar con la capa de persistencia.
     */
    private final ICitaConPacienteDAO citaPacienteDAO;

    /**
     * Instancia del convertidor de citas para convertir entre entidades y DTO.
     */
    private ConvertidorCita convCita;

    /**
     * Instancia del convertidor de citas con pacientes, para convertir entre
     * entidades y DTO.
     */
    private ConvertidorCitaConPaciente convCitaPac;

    /**
     * Logger para registrar mensajes de error y depuración.
     */
    static final Logger logger = Logger.getLogger(CitaNegocio.class.getName());

    /**
     * Constructor de la clase CitaNegocio.
     *
     * Crea una instancia de CitaNegocio y inicializa las instancias de conexión
     * y los DAO necesarios para interactuar con la capa de persistencia.
     */
    public CitaNegocio() {
        this.citaDAO = new CitaDAO(new Conexion(ConstantesPersistencia.colecciones.CITAS, CitaMapeo.class));
        this.pacienteDAO = new PacienteDAO(new Conexion(ConstantesPersistencia.colecciones.PACIENTES, PacienteMapeo.class));
        this.medicoDAO = new MedicoDAO(new Conexion(ConstantesPersistencia.colecciones.MEDICOS, MedicoMapeo.class));
        this.citaPacienteDAO = new CitaConPacienteDAO(new Conexion(ConstantesPersistencia.colecciones.CITAS, CitaConPacienteMapeo.class));
        this.convCita = new ConvertidorCita();
        this.convCitaPac = new ConvertidorCitaConPaciente();
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

    @Override
    public List<CitaConPacienteDTO> obtenerCitas(CitaDTO cita) throws NegocioException {
        List<CitaConPacienteDTO> citas = new ArrayList<>();
        List<CitaConPaciente> citasC;
        try {
            citasC = citaPacienteDAO.obtenerCitas(convCita.DTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas");
            throw new NegocioException("Error al obtener las citas", e);
        }
        if (!citasC.isEmpty()) {
            for (CitaConPaciente c : citasC) {
                citas.add(convCitaPac.EntidadaADTO(c));
            }
        }
        return citas;
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorFecha(CitaDTO cita) throws NegocioException {
        List<CitaConPacienteDTO> citas = new ArrayList<>();
        List<CitaConPaciente> citasC;
        try {
            citasC = citaPacienteDAO.consultarPorFecha(convCita.DTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por fecha");
            throw new NegocioException("Error al obtener las citas por fecha", e);
        }
        if (!citasC.isEmpty()) {
            for (CitaConPaciente c : citasC) {
                citas.add(convCitaPac.EntidadaADTO(c));
            }
        }
        return citas;
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorNombre(String cedula, String nombrePaciente) throws NegocioException {
        List<CitaConPacienteDTO> citas = new ArrayList<>();
        List<CitaConPaciente> citasC;
        try {
            citasC = citaPacienteDAO.consultarPorNombre(cedula, nombrePaciente);
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por nombre");
            throw new NegocioException("Error al obtener las citas por nombre", e);
        }
        if (!citasC.isEmpty()) {
            for (CitaConPaciente c : citasC) {
                citas.add(convCitaPac.EntidadaADTO(c));
            }
        }
        return citas;
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorHora(CitaDTO cita) throws NegocioException {
        List<CitaConPacienteDTO> citas = new ArrayList<>();
        List<CitaConPaciente> citasC;
        try {
            citasC = citaPacienteDAO.consultaPorHora(convCita.DTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por hora");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        if (!citasC.isEmpty()) {
            for (CitaConPaciente c : citasC) {
                citas.add(convCitaPac.EntidadaADTO(c));
            }
        }
        return citas;
    }

    @Override
    public CitaDTO cancelarCita(CitaDTO cita) throws NegocioException {
        CitaDTO persistencia = null;
        Cita resultado;
        try {
            resultado = citaDAO.cancelarCita(convCita.DTOAEntidad(cita));
            persistencia = convCita.EntidadaADTO(resultado);
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al cancelar cita");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        return persistencia;
    }

    @Override
    public CitaDTO reasginarCita(CitaDTO citaReasigna, CitaDTO nueva) throws NegocioException {
        CitaDTO persistencia = null;
        Cita resultado;
        try {
            resultado = citaDAO.ReasignarCita(convCita.DTOAEntidad(citaReasigna), convCita.DTOAEntidad(nueva));
            persistencia = convCita.EntidadaADTO(resultado);
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al cancelar cita");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        return persistencia;
    }

}
