package eliminarMedico;

import dtos.MedicoDTO;

/**
 * Interfaz que define las operaciones para la eliminacion de médicos en el
 * sistema.
 *
 * Esta interfaz proporciona métodos para eliminar nuevos médicos en el sistema
 *
 */
public interface IEliminarMedico {
    
    /**
     * Elimina médico en el sistema.
     *
     * @param medico
     */
    public MedicoDTO eliminarMedico(MedicoDTO medico);
    
}
