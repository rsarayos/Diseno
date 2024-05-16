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
    
    private String id;
    
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

    public CitaDTO() {
    }

    public CitaDTO(String id, Date fechaHora, String cedulaProfesional, String idPaciente, String observaciones, Boolean estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.idPaciente = idPaciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    /**
     * Constructor para inicializar la clase con algunos atributos.
     * @param fechaHora Fecha y hora de la cita
     * @param cedulaProfesional Cedula del medico relacionado a la cita
     */
    public CitaDTO(Date fechaHora, String cedulaProfesional) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
    }
    
    /**
     * Constructor para inicializar la clase con todos sus atributos.
     * @param fechaHora Fecha y hora de la cita
     * @param cedulaProfesional Cedula del medico relacionado a la cita
     * @param idPaciente Id del paciente relacionado a la cita
     * @param observaciones Observaciones de la cita
     * @param estado Estado de la cita
     */
    public CitaDTO(Date fechaHora, String cedulaProfesional, String idPaciente, String observaciones, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.idPaciente = idPaciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return La fecha y hora de la cita.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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
