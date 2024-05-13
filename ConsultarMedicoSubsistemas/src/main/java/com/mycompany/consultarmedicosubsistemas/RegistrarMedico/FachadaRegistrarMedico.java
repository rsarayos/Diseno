package com.mycompany.consultarmedicosubsistemas.RegistrarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IRegistroMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para el registro los
 * médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlRegistroMedico para realizar las
 * operaciones de registro de médicos.
 */
public class FachadaRegistrarMedico implements IRegistrarMedico {

    /**
     * Objeto de la clase ControlRegistrarMedico para realizar las operaciones
     * de registro del medico.
     */
    private final ControlRegistrarMedico control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar
     * las operaciones de registro de médicos.
     */
    public FachadaRegistrarMedico() {
        this.control = new ControlRegistrarMedico();
    }

    /**
     * Llama al método registrarMedico() del objeto de control para realizar el
     * registro del médico.
     *
     * En caso de que ocurra una excepción durante el registro del médico, se
     * registra el error en el sistema de registro de logs.
     * 
     * @param medico envia un MedicoDTO
     * @return regresa un medicoDTO
     */
    @Override
    public MedicoDTO RegistrarMedico(MedicoDTO medico) {
        try {
           return this.control.registrarMedico(medico);
        } catch (Exception e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

}
