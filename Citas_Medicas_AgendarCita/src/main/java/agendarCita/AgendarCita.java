package agendarCita;

import dtos.CitaDTO;

/**
 * Clase que implementa la interfaz IAgendarCita para registrar y consultar citas.
 * 
 * Esta clase proporciona métodos para registrar y consultar citas mediante la delegación
 * de las operaciones al objeto AgendarCitaCO.
 * 
 */
public class AgendarCita implements IAgendarCita {

    /** Objeto de la clase AgendarCitaCO para realizar las operaciones de registro y consulta de citas. */
    private final AgendarCitaCO control;

    /**
     * Constructor de la clase AgendarCita.
     * 
     * Se inicializa el objeto de control AgendarCitaCO.
     */
    public AgendarCita() {
        control = new AgendarCitaCO();
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
