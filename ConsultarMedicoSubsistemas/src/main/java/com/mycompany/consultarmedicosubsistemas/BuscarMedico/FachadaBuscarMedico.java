package com.mycompany.consultarmedicosubsistemas.BuscarMedico;

import com.mycompany.consultarmedicobo.objetosNegocio.MedicoNegocio;
import com.mycompany.consultarmedicodto.DTOS.MedicoDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IBuscarMedico y actúa como intermediario
 * entre la interfaz de usuario y la lógica de negocio para la busqueda de
 * información de los médicos en el sistema.
 *
 * Esta clase utiliza un objeto ControlBuscarMedico para realizar las
 * operaciones de buscar médicos.
 */
public class FachadaBuscarMedico implements IBuscarMedico {

    /**
     * Objeto de la clase ControlConsultarMedico para realizar las operaciones
     * de consultar al medico.
     */
    private final ControlBuscarMedico control;

    /**
     * Constructor de la clase. Inicializa el objeto de control para realizar
     * las operaciones de buscar de médicos.
     */
    public FachadaBuscarMedico() {
        this.control = new ControlBuscarMedico();
    }

    /**
     * Llama al método buscarMedico() del objeto de control para realizar la
     * busqueda del médico.
     *
     * @param nombre
     * @param cedula
     * @param especialidad
     * @return
     */
    @Override
    public List<MedicoDTO> buscarMedico(String nombre, String cedula, String especialidad) {
        List<MedicoDTO> medicos = null;
        try {
            medicos = this.control.buscarMedico(nombre, cedula, especialidad);
        } catch (Exception e) {
            Logger.getLogger(MedicoNegocio.class.getName()).log(Level.SEVERE, null, e);
        }
        return medicos;
    }
}
