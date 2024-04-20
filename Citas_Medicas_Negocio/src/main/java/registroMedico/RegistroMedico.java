package registroMedico;

import dtos.MedicoDTO;

/**
 *
 * @author alex_
 */
public class RegistroMedico implements IRegistroMedico {
    
    private final RegistroMedicoCO control;

    public RegistroMedico() {
        this.control = new RegistroMedicoCO();
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
