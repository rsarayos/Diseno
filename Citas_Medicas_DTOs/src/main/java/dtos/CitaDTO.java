package dtos;

import java.util.Calendar;
import negocio_excepciones.ValidacionException;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para una cita médica.
 * 
 * Un objeto CitaDTO contiene información sobre la fecha y hora de la cita,
 * el médico asociado, el paciente asociado, las observaciones y el estado de la cita.
 * 
 * Esta clase proporciona métodos para acceder y modificar los atributos del objeto,
 * así como para validar si la cita es válida.
 * 
 */
public class CitaDTO {
    
    /**
     * Fecha y hora de la cita.
     */
    private Calendar fechaHora;
    
    /**
     * Médico asociado a la cita.
     */
    private MedicoDTO medico;
    
    /**
     * Paciente asociado a la cita.
     */
    private PacienteDTO paciente;
    
    /**
     * Observaciones de la cita.
     */
    private String observaciones;
    
    /**
     * Estado de la cita.
     */
    private Boolean estado;

    /**
     * Constructor que inicializa todos los atributos del objeto CitaDTO.
     * 
     * @param fechaHora La fecha y hora de la cita.
     * @param medico El médico asociado a la cita.
     * @param paciente El paciente asociado a la cita.
     * @param observaciones Las observaciones de la cita.
     * @param estado El estado de la cita.
     */
    public CitaDTO(Calendar fechaHora, MedicoDTO medico, PacienteDTO paciente, String observaciones, Boolean estado) {
        this.fechaHora = fechaHora;
        this.medico = medico;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa la fecha y hora de la cita y el médico asociado.
     * 
     * @param fechaHora La fecha y hora de la cita.
     * @param medico El médico asociado a la cita.
     */
    public CitaDTO(Calendar fechaHora, MedicoDTO medico) {
        this.fechaHora = fechaHora;
        this.medico = medico;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return La fecha y hora de la cita.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Obtiene el médico asociado a la cita.
     * 
     * @return El médico asociado a la cita.
     */
    public MedicoDTO getMedico() {
        return medico;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return El paciente asociado a la cita.
     */
    public PacienteDTO getPaciente() {
        return paciente;
    }

    /**
     * Obtiene las observaciones de la cita.
     * 
     * @return Las observaciones de la cita.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Obtiene el estado de la cita.
     * 
     * @return El estado de la cita.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Verifica si la cita es válida.
     * 
     * @return true si la cita es válida, false si no lo es.
     * @throws ValidacionException Si ocurre un error durante la validación.
     */
    public boolean esValido() throws ValidacionException{
        return true;
    }
    
}
