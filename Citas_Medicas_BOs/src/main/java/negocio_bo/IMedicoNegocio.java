package negocio_bo;

import dtos.MedicoDTO;

/**
 *
 * @author alex_
 */
public interface IMedicoNegocio {
    
    public void registrarMedico();
    public MedicoDTO obtenerMedico(String numCedula);
    
}
