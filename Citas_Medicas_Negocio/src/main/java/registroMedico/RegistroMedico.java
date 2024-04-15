package registroMedico;

import dtos.MedicoDTO;
import java.util.logging.Logger;
import negocio_bo.IMedicoNegocio;
import negocio_bo.MedicoNegocio;

/**
 *
 * @author alex_
 */
public class RegistroMedico implements IRegistroMedico {
    
    private final IMedicoNegocio medicoBo; 
    static final Logger logger = Logger.getLogger(RegistroMedico.class.getName());

    public RegistroMedico() {
        this.medicoBo = new MedicoNegocio();
    }

    @Override
    public void registrarMedico() {
        
        medicoBo.registrarMedico();
        
    }

    @Override
    public MedicoDTO obtenerMedico(String numCedula) {
        
        return medicoBo.obtenerMedico(numCedula);
        
    }
    
}
