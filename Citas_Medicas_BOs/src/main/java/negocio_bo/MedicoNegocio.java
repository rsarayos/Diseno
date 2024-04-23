package negocio_bo;

import citas_medicas_dao.Conexion;
import citas_medicas_dao.IConexion;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.MedicoDAO;
import citas_medicas_dao.MedicoDAOListas;
import citas_medicas_entidades.Medico;
import citas_medicas_persistancia_excepciones.PersistenciaException;
import convertidores.ConvertidorMedico;
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
    
    /** Objeto para gestionar la conexión a la base de datos. */
    private final IConexion conexion;
    
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
        this.conexion = new Conexion();
        this.medicoDAO = new MedicoDAO(conexion);
        this.convMedico = new ConvertidorMedico();
    }

    /**
     * Constructor de la clase MedicoNegocio para utilizar con listas.
     * 
     * @param medicoDAO objeto dao con la lista de medicos
     */
    public MedicoNegocio(MedicoDAOListas medicoDAO) {
        this.conexion = new Conexion();
        this.medicoDAO = medicoDAO;
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
            medico = convMedico.convertidorEntidadaADTO(medicoObt);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medico;
    }
    
}
