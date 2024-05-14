package consultarMedico;

import dtos.MedicoDTO;
import java.util.List;

/**
 * Clase que implementa la interfaz IConsultarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para la obtención de
 * información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlConsultarMedico para realizar las
 * operaciones de registro de médicos.
 */
public class FConsultarMedico implements IConsultarMedico{
    
    /**
     * Objeto de la clase ControlConsultarMedico para realizar las operaciones
     * de consultar al medico.
     */
    private final CConsultarMedico control;

    public FConsultarMedico() {
        this.control = new CConsultarMedico();
    }
    
    

    @Override
    public List<MedicoDTO> consultarMedicos() {
        return control.consultarMedico();
    }
    
}
