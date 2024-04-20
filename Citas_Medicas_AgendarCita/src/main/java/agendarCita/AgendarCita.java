package agendarCita;

import dtos.CitaDTO;

/**
 *
 * @author alex_
 */
public class AgendarCita implements IAgendarCita {

    private final AgendarCitaCO control;

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
