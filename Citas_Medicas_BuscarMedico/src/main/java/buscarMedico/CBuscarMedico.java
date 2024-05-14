package buscarMedico;

import dtos.MedicoDTO;
import excepcionesNegocio.NegocioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.IMedicoNegocio;
import objetosNegocio.MedicoNegocio;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica
 * de negocio para el la busqueda de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de
 * busqueda de médicos. También registra eventos de registro de médicos
 * mediante un objeto Logger.
 */
public class CBuscarMedico {
    
    /**
     * Objeto de negocio que realiza las operaciones relacionadas con los
     * medicos.
     */
    private final IMedicoNegocio medicoBO;

    /**
     * Objeto Logger para la gestión de logs.
     */
    static final Logger logger = Logger.getLogger(CBuscarMedico.class.getName());

    public CBuscarMedico() {
        this.medicoBO = new MedicoNegocio();
    }
    
    /**
     * Busca un médico en el sistema utilizando el objeto de negocio y registra
     * el evento en el Logger.
     * 
     * @param nombre nombre del medico
     * @param cedula cedula del medico
     * @param especialidad especialidad del medico
     * @return regresa un medicoDTO
     */
    protected List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) {
        List<MedicoDTO> medicos = null;
        try {
            medicos = this.medicoBO.buscarMedico(nombre, cedula, especialidad);
        } catch (NegocioException ex) {
            Logger.getLogger(CBuscarMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
}
