package entidades;

import java.io.Serializable;
import java.util.Date;
import org.bson.types.ObjectId;


/**
 * Clase que representa una cita médica.
 * 
 * Una cita médica tiene una fecha y hora, un médico, un paciente,
 * una observación opcional y un estado que indica si la cita está activa o no.
 * 
 * La clase incluye métodos para acceder y modificar los atributos de la cita,
 * así como métodos de utilidad como equals y hashCode para comparar citas
 * basadas en su identificador único.
 * 
 */
public class Cita implements Serializable {

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
    public Cita() {
    }

    public Cita(Date fechaHora, String cedulaProfesional, ObjectId idPaciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.idPaciente = idPaciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public ObjectId getIdPaciente() {
        return idPaciente;
    }

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
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación de cadena de la cita.
     * 
     * @return Una representación de cadena de la cita.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita{");
        sb.append("_id=").append(_id);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", cedulaProfesional=").append(cedulaProfesional);
        sb.append(", idPaciente=").append(idPaciente);
        sb.append(", observacion=").append(observacion);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
