package Entidades;

import java.util.Calendar;

/**
 *
 * @author alex_
 */
public class Cita {
    
    private Calendar fecha;
    private Paciente paciente;
    private String observaciones;

    public Cita(Calendar fecha, Paciente paciente, String observaciones) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.observaciones = observaciones;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    
    
}
