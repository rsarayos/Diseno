package entidadesMapeo;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author alex_
 */
public class CitaConPacienteMapeo {
    
    //Atributos de la clases combinadas
    private ObjectId id;
    private Date fechaHora;
    private String cedulaProfesional;
    private PacienteMapeo paciente;
    private String observacion;
    private Boolean estado;

    public CitaConPacienteMapeo() {
    }
    
    public CitaConPacienteMapeo(ObjectId id, Date fechaHora, String cedulaProfesional, PacienteMapeo paciente, String observacion, Boolean estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public CitaConPacienteMapeo(Date fechaHora, String cedulaProfesional, PacienteMapeo paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public PacienteMapeo getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteMapeo paciente) {
        this.paciente = paciente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CitaConPacienteMapeo other = (CitaConPacienteMapeo) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
