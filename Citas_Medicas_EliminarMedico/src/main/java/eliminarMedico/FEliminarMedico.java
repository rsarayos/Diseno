package eliminarMedico;

import dtos.MedicoDTO;

/**
 * Clase que implementa la interfaz IEliminarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para el registro y la
 * obtención de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlEliminarMedico para realizar las
 * operaciones de registro y obtención de médicos.
 *
 */
public class FEliminarMedico implements IEliminarMedico {

    /**
     * Objeto de la clase ControlRegistrarMedico para realizar las operaciones
     * de eliminacion del medico.
     */
    private final CEliminarMedico control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar
     * las operaciones de eliminacion de médicos.
     */
    public FEliminarMedico() {
        this.control = new CEliminarMedico();
    }
    
    @Override
    public MedicoDTO eliminarMedico(MedicoDTO medico) {
        return control.eliminarMedico(medico);
    }
    
}
