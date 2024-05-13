package com.mycompany.consultarmedicosubsistemas.RegistrarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.IMedicoNegocio;
import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Excepciones.NegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica
 * de negocio para el registro de información de los médicos en
 * el sistema.
 *
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de
 * registro de médicos. También registra eventos de registro de
 * médicos mediante un objeto Logger.
 *
 */
public class ControlRegistrarMedico {

    /**
     * Objeto de negocio que realiza las operaciones relacionadas con los
     * medicos.
     */
    private final IMedicoNegocio medicoBO;

    /**
     * Objeto Logger para la gestión de logs.
     */
    static final Logger logger = Logger.getLogger(ControlRegistrarMedico.class.getName());

    /**
     * Constructor de la clase. Inicializa el objeto de medicoBO para realizar
     * las operaciones de registro de médicos.
     */
    public ControlRegistrarMedico() {
        this.medicoBO = new MedicoNegocio();
    }

    /**
     * Registra un nuevo médico en el sistema utilizando el objeto de negocio y
     * registra el evento en el Logger.
     * 
     * @param medico Envia un objeto MedicoDTO
     * @return Regresa el metodo registrar medico
     */
    protected MedicoDTO registrarMedico(MedicoDTO medico) {
        try {
            return this.medicoBO.registrarMedico(medico);
        } catch (NegocioException e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
