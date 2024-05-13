package com.mycompany.consultarmedicosubsistemas.ConsultarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IConsultarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para la obtención de
 * información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlConsultarMedico para realizar las
 * operaciones de registro de médicos.
 */
public class FachadaConsultarMedico implements IConsultarMedico {

    /**
     * Objeto de la clase ControlConsultarMedico para realizar las operaciones
     * de consultar al medico.
     */
    private final ControlConsultarMedico control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar
     * las operaciones de consultar de médicos.
     */
    public FachadaConsultarMedico() {
        this.control = new ControlConsultarMedico();
    }
    
    /**
     * Llama al método consultarMedico() del objeto de control para realizar la
     * consulta del médico.
     *
     * En caso de que ocurra una excepción durante la obtencion del médico, se
     * registra el error en el sistema de registro de logs.
     */
    @Override
    public List<MedicoDTO> consultarMedico() {
        List<MedicoDTO> medicos = null;
        try {
            medicos = this.control.consultarMedico();
        } catch (Exception e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return medicos;
    }

}
