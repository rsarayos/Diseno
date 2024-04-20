package registroMedico;

import dtos.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_bo.IMedicoNegocio;
import negocio_bo.MedicoNegocio;

/**
 *
 * @author alex_
 */
public class RegistroMedicoCO {
    
    private final IMedicoNegocio medicoBo; 
    static final Logger logger = Logger.getLogger(RegistroMedico.class.getName());

    public RegistroMedicoCO() {
        this.medicoBo = new MedicoNegocio();
    }
    
    protected void registrarMedico() {
        
        medicoBo.registrarMedico();
        logger.log(Level.INFO, "Se ha registrado al medico");
        
    }
    
    protected MedicoDTO obtenerMedico(String numCedula) {
        
        return medicoBo.obtenerMedico(numCedula);
        
    }
    
}
