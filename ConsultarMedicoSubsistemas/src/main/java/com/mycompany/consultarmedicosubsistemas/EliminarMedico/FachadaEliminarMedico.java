/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultarmedicosubsistemas.EliminarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IEliminarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para el registro y la
 * obtención de información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlEliminarMedico para realizar las
 * operaciones de registro y obtención de médicos.
 *
 */
public class FachadaEliminarMedico implements IEliminarMedico {

    /**
     * Objeto de la clase ControlRegistrarMedico para realizar las operaciones
     * de eliminacion del medico.
     */
    private final ControlEliminarMedico control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar
     * las operaciones de eliminacion de médicos.
     */
    public FachadaEliminarMedico() {
        this.control = new ControlEliminarMedico();
    }

    /**
     * Llama al método EliminarMedico() del objeto de control para realizar la
     * eliminacion del médico.
     *
     * En caso de que ocurra una excepción durante la eliminacion del médico, se
     * registra el error en el sistema de registro de logs.
     */
    @Override
    public MedicoDTO eliminarMedico(MedicoDTO medico) {
        try {
            return control.eliminarMedico(medico);
        } catch (Exception e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
