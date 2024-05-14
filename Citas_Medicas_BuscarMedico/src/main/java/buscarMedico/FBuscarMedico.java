package buscarMedico;

import dtos.MedicoDTO;
import java.util.List;

/**
 * Clase que implementa la interfaz IBuscarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para la busqueda de
 * información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlBuscarMedico para realizar las
 * operaciones de buscar médicos.
 */
public class FBuscarMedico implements IBuscarMedico{

    /**
     * Objeto de la clase ControlConsultarMedico para realizar las operaciones
     * de consultar al medico.
     */
    private final CBuscarMedico control;

    public FBuscarMedico() {
        this.control = new CBuscarMedico();
    }
    
    @Override
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) {
        
        return control.buscarMedico(nombre, cedula, especialidad);
        
    }
    
}
