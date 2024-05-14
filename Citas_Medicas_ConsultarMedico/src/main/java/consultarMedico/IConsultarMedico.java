package consultarMedico;

import dtos.MedicoDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones para la consulta de médicos en el
 * sistema.
 *
 * Esta interfaz proporciona métodos para obtener médicos en el sistema
 */
public interface IConsultarMedico {
    
    /**
     * Consulta los medicos en el sistema.
     *
     * @return
     */
    public List<MedicoDTO> consultarMedicos();
    
}
