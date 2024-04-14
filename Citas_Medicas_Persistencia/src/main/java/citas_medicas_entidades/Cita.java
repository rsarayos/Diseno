package citas_medicas_entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;
    
    @Column(name = "fecha_cita", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    
    @ManyToOne
    @JoinColumn(name = "cedula_medico", nullable = false)
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    
    @Column(name = "observacion", length = 100)
    private String observacion;
    
    @Column(name = "estado")
    private Boolean estado;

    public Cita() {
    }

    public Cita(Calendar fechaHora, Medico medico, Paciente paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.medico = medico;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cita{");
        sb.append("id=").append(id);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", medico=").append(medico);
        sb.append(", paciente=").append(paciente);
        sb.append(", observacion=").append(observacion);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
