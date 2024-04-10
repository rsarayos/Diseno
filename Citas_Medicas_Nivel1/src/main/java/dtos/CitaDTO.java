package dtos;

import java.util.Calendar;

/**
 *
 * @author alex_
 */
public class CitaDTO {
    
    private Calendar fecha;
    private PacienteDTO paciente;
    private String observaciones;

    public CitaDTO(Calendar fecha, PacienteDTO paciente, String observaciones) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.observaciones = observaciones;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
}
