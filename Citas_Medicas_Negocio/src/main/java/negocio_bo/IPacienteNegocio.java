package negocio_bo;

import dtos.PacienteDTO;
import java.util.List;
import negocio_excepciones.NegocioException;

/**
 *
 * @author alex_
 */
public interface IPacienteNegocio {
    
    public PacienteDTO registrarPaciente(PacienteDTO paciente) throws NegocioException;
    public List<PacienteDTO> obtenerPacientes() throws NegocioException;
    
}
