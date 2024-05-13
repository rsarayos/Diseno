package objetosNegocio;

import dao.Conexion;
import dao.IMedicoDAO;
import dao.MedicoDAO;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import convertidores.ConvertidorMedico;
import dao.ConstantesPersistencia;
import dtos.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IMedicoNegocio y define la lógica de negocio relacionada con los médicos.
 * 
 * Proporciona métodos para registrar un nuevo médico y obtener información de un médico existente.
 * 
 */
public class MedicoNegocio implements IMedicoNegocio {
       
    /** Objeto para interactuar con la capa de acceso a datos de los medicos. */
    private final IMedicoDAO medicoDAO;
    
    /** Objeto para convertir entre DTO y entidad de medico. */
    private ConvertidorMedico convMedico;
    
    /** Logger para registrar mensajes de registro. */
    static final Logger logger = Logger.getLogger(MedicoNegocio.class.getName());

    /**
     * Constructor de la clase MedicoNegocio.
     * 
     * Inicializa los atributos de conexión, objeto de acceso a datos de médico (DAO) y convertidor de médico.
     */
    public MedicoNegocio() {
        this.medicoDAO = new MedicoDAO(new Conexion(ConstantesPersistencia.colecciones.MEDICOS, Medico.class));
        this.convMedico = new ConvertidorMedico();
    }

    @Override
    public void registrarMedico() {
        try {
            medicoDAO.agregarMedicos();
        } catch (PersistenciaException ex) {
            logger.log(Level.INFO, "Se registro el usuario");
        }
    }

    @Override
    public MedicoDTO obtenerMedico(String numCedula) {
        MedicoDTO medico = null;
        try {
            Medico medicoObt = medicoDAO.obtenerMedicoCedula(numCedula);
            medico = convMedico.EntidadaADTO(medicoObt);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medico;
    }
    
}
