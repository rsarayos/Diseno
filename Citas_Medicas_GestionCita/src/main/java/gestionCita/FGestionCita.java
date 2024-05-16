package gestionCita;

import dtos.CitaConPacienteDTO;
import dtos.CitaDTO;
import java.util.List;

/**
 * Clase para realizar las metodos
 */
public class FGestionCita implements IGestionCita {

    private CGestionCita control;

    public FGestionCita() {
        this.control = new CGestionCita();
    }

    @Override
    public List<CitaConPacienteDTO> obtenerCitas(CitaDTO cita) {
        return this.control.obtenerCitas(cita);
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorFecha(CitaDTO cita) {
        return this.control.obtenerCitaFecha(cita);
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorNombre(String cedula, String nombrePaciente) {
        return control.obtenerCitaNombre(cedula, nombrePaciente);
    }

    @Override
    public List<CitaConPacienteDTO> consultarPorHora(CitaDTO cita) {
        return control.obtenerCitaHora(cita);
    }

    @Override
    public CitaDTO cancelarCita(CitaDTO cita) {
        return control.cancelarCita(cita);
    }

    @Override
    public CitaDTO reasignarCita(CitaDTO citaReasignar, CitaDTO nueva) {
        return control.reasignarCita(citaReasignar, nueva);
    }

}
