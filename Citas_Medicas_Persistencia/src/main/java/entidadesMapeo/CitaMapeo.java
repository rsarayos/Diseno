package entidadesMapeo;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que sirve para mapear la entidad cita dentro de una base de datos
 */
public class CitaMapeo {
    
    /**
     * Identificador único de la cita.
     */
    private ObjectId _id;
    
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
    private ObjectId idPaciente;
    
    /**
     * Observación adicional sobre la cita (opcional).
     */
    private String observacion;
    
    /**
     * Estado de la cita (activo/inactivo).
     */
    private Boolean estado;

    /**
     * Constructor por defecto de la clase Cita.
     */
    public CitaMapeo() {
    }

    /**
     * Constructor para inicializar los atributos de la clase
     * @param fechaHora fecha y hora de la cita
     * @param cedulaProfesional cedula del medico
     * @param idPaciente id del paciente
     * @param observacion observaciones de la citas
     * @param estado estado de la cita
     */
    public CitaMapeo(Date fechaHora, String cedulaProfesional, ObjectId idPaciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.idPaciente = idPaciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    /**
     * Obtiene el object id de la cita.
     * 
     * @return el id de la cita.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el object id de la cita.
     * 
     * @param _id El nuevo id de la cita.
     */
    public void setId(ObjectId _id) {
        this._id = _id;
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
     * Establece la fecha y hora de la cita.
     * 
     * @param fechaHora La nueva fecha y hora de la cita.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene la cedula del medico relacionado a la cita.
     * 
     * @return cedula del medico de la cita.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cedula del medico relacionado a la cita.
     * 
     * @param cedulaProfesional cedula del medico a establecer en la cita
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Obtiene el id del paciente relacionado a la cita.
     * 
     * @return El id del paciente relacionado.
     */
    public ObjectId getIdPaciente() {
        return idPaciente;
    }

    /**
     * Establece el id del paciente relacionado a la cita.
     * 
     * @param idPaciente id del paciente a establecer en la cita
     */
    public void setIdPaciente(ObjectId idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * Obtiene la observación adicional sobre la cita.
     * 
     * @return La observación adicional sobre la cita.
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Establece la observación adicional sobre la cita.
     * 
     * @param observacion La nueva observación adicional sobre la cita.
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
     * Establece el estado de la cita.
     * 
     * @param estado El nuevo estado de la cita.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Calcula el hash code de la cita.
     * 
     * @return El hash code de la cita.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si esta cita es igual a otro objeto dado.
     * 
     * @param object El objeto a comparar con esta cita.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaMapeo)) {
            return false;
        }
        CitaMapeo other = (CitaMapeo) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }
    
}
