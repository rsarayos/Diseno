package agendarCita;

import dtos.CitaDTO;

/**
 * Clase que implementa la interfaz IAgendarCita para registrar y consultar citas.
 * 
 * Esta clase proporciona métodos para registrar y consultar citas mediante la delegación
 * de las operaciones al objeto AgendarCitaCO.
 * 
 */
public class FAgendarCita implements IAgendarCita {

    /** Objeto de la clase CAgendarCita para realizar las operaciones de registro y consulta de citas. */
    private final CAgendarCita control;

    /**
     * Constructor de la clase AgendarCita.
     * 
     * Se inicializa el objeto de control AgendarCitaCO.
     */
    public FAgendarCita() {
        control = new CAgendarCita();
    }

    @Override
    public CitaDTO registrarCita(CitaDTO nuevaCita) {

        return control.registrarCita(nuevaCita);
        
    }

    @Override
    public CitaDTO consultarDisponibilidadCita(CitaDTO nuevaCita) {
        
        return control.consultarDisponibilidadCita(nuevaCita);
        
    }

}
