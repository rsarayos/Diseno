package eliminarMedico;

import dtos.MedicoDTO;
import excepcionesNegocio.NegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.IMedicoNegocio;
import objetosNegocio.MedicoNegocio;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica
 * de negocio para la eliminacion de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de
 * eliminacion de médicos. También registra eventos de eliminacion de médicos
 * mediante un objeto Logger.
 *
 */
public class CEliminarMedico {
    
    private final IMedicoNegocio medicoBO;

    /**
     * Objeto Logger para la gestión de logs.
     */
    static final Logger logger = Logger.getLogger(CEliminarMedico.class.getName());

    public CEliminarMedico() {
        this.medicoBO = new MedicoNegocio();
    }
    
    /**
     * Elimina a un médico en el sistema utilizando el objeto de negocio y
     * registra el evento en el Logger.
     * 
     * @param medico Envia un objeto MedicoDTO
     * @return Regresa el Metodo eliminarMedico
     */
    protected MedicoDTO eliminarMedico(MedicoDTO medico) {
      
            
        try {
            return medicoBO.eliminarMedico(medico);
        } catch (NegocioException ex) {
            Logger.getLogger(CEliminarMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
