package registroMedico;

import dtos.MedicoDTO;

/**
 *
 * @author alex_
 */
public interface IRegistroMedico {
    
    public void registrarMedico();
    public MedicoDTO obtenerMedico(String numCedula);
    
}
