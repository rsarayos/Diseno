package registroMedico;

import citas_medicas_dao.MedicoDAOListas;
import dtos.MedicoDTO;

/**
 * Clase que implementa la interfaz IRegistroMedico y actúa como intermediario entre la interfaz de usuario
 * y la lógica de negocio para el registro y la obtención de información de los médicos en el sistema.
 * 
 * Esta clase utiliza un objeto RegistroMedicoCO para realizar las operaciones de registro y obtención de médicos.
 * 
 */
public class RegistroMedico implements IRegistroMedico {
    
    /** Objeto de la clase RegistrarMedicoCO para realizar las operaciones de registro del medico. */
    private final RegistroMedicoCO control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar las operaciones de registro y obtención de médicos.
     */
    public RegistroMedico() {
        this.control = new RegistroMedicoCO();
    }

    public RegistroMedico(MedicoDAOListas medicoDAO) {
        this.control = new RegistroMedicoCO(medicoDAO);
    }

    @Override
    public void registrarMedico() {
        
        control.registrarMedico();
        
    }

    @Override
    public MedicoDTO obtenerMedico(String numCedula) {
        
        return control.obtenerMedico(numCedula);
        
    }
    
}
