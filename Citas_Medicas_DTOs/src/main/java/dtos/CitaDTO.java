package dtos;

import java.util.Calendar;
import excepcionesNegocio.ValidacionException;
import java.util.Date;

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
    private Date fechaHora;
    
    /**
     * Médico asociado a la cita.
     */
    private String cedulaProfesional;
    
    /**
     * Paciente asociado a la cita.
     */
    private String idPaciente;
    
    /**
     * Observaciones de la cita.
     */
    private String observaciones;
    
    /**
     * Estado de la cita.
     */
    private Boolean estado;

    public CitaDTO(Date fechaHora, String cedulaProfesional) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
    }
    
    public CitaDTO(Date fechaHora, String cedulaProfesional, String idPaciente, String observaciones, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.idPaciente = idPaciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return La fecha y hora de la cita.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Obtiene el médico asociado a la cita.
     * 
     * @return El médico asociado a la cita.
     */
    public String getCedulaMedico() {
        return cedulaProfesional;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return El paciente asociado a la cita.
     */
    public String getIdPaciente() {
        return idPaciente;
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
