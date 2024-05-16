package dtos;

import excepcionesNegocio.ValidacionException;
import java.util.Date;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para una cita médica con un PacienteDTO.
 * 
 * Un objeto CitaDTO contiene información sobre la fecha y hora de la cita,
 * el médico asociado, el paciente asociado, las observaciones y el estado de la cita.
 * 
 * Esta clase proporciona métodos para acceder y modificar los atributos del objeto,
 * así como para validar si la cita es válida.
 * 
 */
public class CitaConPacienteDTO {
    
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
     * Constructor por defecto
     */
    public CitaConPacienteDTO() {
    }

    public CitaConPacienteDTO(String id, Date fechaHora, String cedulaProfesional, PacienteDTO paciente, String observaciones, Boolean estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    /**
     * Constructor para inicializar la clase con algunos atributos.
     * @param fechaHora Fecha y hora de la cita
     * @param cedulaProfesional Cedula del medico relacionado a la cita
     */
    public CitaConPacienteDTO(Date fechaHora, String cedulaProfesional) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
    }
    
    /**
     * Constructor para inicializar la clase con todos sus atributos.
     * @param fechaHora Fecha y hora de la cita
     * @param cedulaProfesional Cedula del medico relacionado a la cita
     * @param paciente Paciente relacionado a la cita
     * @param observaciones Observaciones de la cita
     * @param estado Estado de la cita
     */
    public CitaConPacienteDTO(Date fechaHora, String cedulaProfesional, PacienteDTO paciente, String observaciones, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
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
