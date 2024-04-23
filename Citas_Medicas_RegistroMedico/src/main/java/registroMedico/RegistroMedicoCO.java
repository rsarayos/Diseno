package registroMedico;

import citas_medicas_dao.MedicoDAOListas;
import dtos.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_bo.IMedicoNegocio;
import negocio_bo.MedicoNegocio;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica de negocio para el registro y
 * la obtención de información de los médicos en el sistema.
 * 
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de registro y obtención de médicos.
 * También registra eventos de registro de médicos mediante un objeto Logger.
 * 
 */
public class RegistroMedicoCO {
    
    /** Objeto de negocio que realiza las operaciones relacionadas con los pacientes. */
    private final IMedicoNegocio medicoBo; 
    
    /** Objeto Logger para la gestión de logs. */
    static final Logger logger = Logger.getLogger(RegistroMedicoCO.class.getName());

    /**
     * Constructor de la clase. Inicializa el objeto de negocio para realizar las operaciones relacionadas con los médicos.
     */
    public RegistroMedicoCO() {
        this.medicoBo = new MedicoNegocio();
    }

    public RegistroMedicoCO(MedicoDAOListas medicoDAO) {
        this.medicoBo = new MedicoNegocio(medicoDAO);
    }
    
    /**
     * Registra un nuevo médico en el sistema utilizando el objeto de negocio y registra el evento en el Logger.
     */
    protected void registrarMedico() {
        
        medicoBo.registrarMedico();
        logger.log(Level.INFO, "Se ha registrado al medico");
        
    }
    
    /**
     * Obtiene la información de un médico mediante su número de cédula profesional utilizando el objeto de negocio.
     * 
     * @param numCedula el número de cédula profesional del médico a obtener.
     * @return un objeto MedicoDTO que contiene la información del médico, o null si no se encuentra.
     */
    protected MedicoDTO obtenerMedico(String numCedula) {
        
        return medicoBo.obtenerMedico(numCedula);
        
    }
    
}
