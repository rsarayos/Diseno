package com.mycompany.consultarmedicosubsistemas.BuscarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.IMedicoNegocio;
import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import com.mycompany.consultarmediconegocio.Excepciones.NegocioException;
import com.mycompany.consultarmedicosubsistemas.RegistrarMedico.ControlRegistrarMedico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que actúa como intermediario entre la interfaz de usuario y la lógica
 * de negocio para el la busqueda de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto MedicoNegocio para realizar las operaciones de
 * busqueda de médicos. También registra eventos de registro de médicos
 * mediante un objeto Logger.
 */
public class ControlBuscarMedico {

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
     * las operaciones de buscar médicos.
     */
    public ControlBuscarMedico() {
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
        } catch (NegocioException e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return medicos;
    }
}
