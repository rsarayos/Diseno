package com.mycompany.consultarmedicosubsistemas.EliminarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.IMedicoNegocio;
import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Excepciones.NegocioException;
import com.mycompany.consultarmedicosubsistemas.RegistrarMedico.ControlRegistrarMedico;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica
 * de negocio para la eliminacion de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de
 * eliminacion de médicos. También registra eventos de eliminacion de médicos
 * mediante un objeto Logger.
 *
 */
public class ControlEliminarMedico {

    private final IMedicoNegocio medicoBO;

    /**
     * Objeto Logger para la gestión de logs.
     */
    static final Logger logger = Logger.getLogger(ControlRegistrarMedico.class.getName());

    /**
     * Constructor de la clase. Inicializa el objeto de medicoBO para realizar
     * las operaciones de eliminacion de médicos.
     */
    public ControlEliminarMedico() {
        this.medicoBO = new MedicoNegocio();
    }

    /**
     * Elimina a un médico en el sistema utilizando el objeto de negocio y
     * registra el evento en el Logger.
     * 
     * @param medico Envia un objeto MedicoDTO
     * @return Regresa el Metodo eliminarMedico
     */
    protected MedicoDTO eliminarMedico(MedicoDTO medico) {
        try {
            return medicoBO.eliminarMedico(medico);
        } catch (NegocioException e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
