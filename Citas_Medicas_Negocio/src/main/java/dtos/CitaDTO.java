package dtos;

import java.util.Calendar;
import negocio_excepciones.ValidacionException;

/**
 *
 * @author alex_
 */
public class CitaDTO {
    
    private Calendar fechaHora;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    private String observaciones;
    private Boolean estado;

    public CitaDTO(Calendar fechaHora, MedicoDTO medico, PacienteDTO paciente, String observaciones, Boolean estado) {
        this.fechaHora = fechaHora;
        this.medico = medico;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public CitaDTO(Calendar fechaHora, MedicoDTO medico) {
        this.fechaHora = fechaHora;
        this.medico = medico;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public MedicoDTO getMedico() {
        return medico;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Boolean getEstado() {
        return estado;
    }

    public boolean esValido() throws ValidacionException{
        return true;
    }
    
}
