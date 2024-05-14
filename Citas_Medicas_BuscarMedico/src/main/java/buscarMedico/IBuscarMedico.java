package buscarMedico;

import dtos.MedicoDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones para la busqueda de médicos en el
 * sistema.
 *
 * Esta interfaz proporciona métodos para buscar médicos en el sistema
 */
public interface IBuscarMedico {
    
    /**
     * Busca un médico en el sistema.
     * 
     * @param nombre
     * @param cedula
     * @param especialidad
     * @return El medico encontrado
     */
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad);
    
}
