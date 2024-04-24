package entidades;

import java.io.Serializable;
import java.util.Calendar;
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
@Entity
@Table(name = "citas")
public class Cita implements Serializable {

    /**
     * Identificador único de la cita.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;
    
    /**
     * Fecha y hora de la cita.
     */
    @Column(name = "fecha_cita", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    
    /**
     * Médico asociado a la cita.
     */
    @ManyToOne
    @JoinColumn(name = "cedula_medico", nullable = false)
    private Medico medico;
    
    /**
     * Paciente asociado a la cita.
     */
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    
    /**
     * Observación adicional sobre la cita (opcional).
     */
    @Column(name = "observacion", length = 100)
    private String observacion;
    
    /**
     * Estado de la cita (activo/inactivo).
     */
    @Column(name = "estado")
    private Boolean estado;

    /**
     * Constructor por defecto de la clase Cita.
     */
    public Cita() {
    }

    /**
     * Constructor que inicializa todos los atributos de la cita.
     * 
     * @param fechaHora Fecha y hora de la cita.
     * @param medico Médico asociado a la cita.
     * @param paciente Paciente asociado a la cita.
     * @param observacion Observación adicional sobre la cita.
     * @param estado Estado de la cita.
     */
    public Cita(Calendar fechaHora, Medico medico, Paciente paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.medico = medico;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único de la cita.
     * 
     * @return El identificador único de la cita.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la cita.
     * 
     * @param id El nuevo identificador único de la cita.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Establece la fecha y hora de la cita.
     * 
     * @param fechaHora La nueva fecha y hora de la cita.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el médico asociado a la cita.
     * 
     * @return El médico asociado a la cita.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado a la cita.
     * 
     * @param medico El nuevo médico asociado a la cita.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return El paciente asociado a la cita.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param paciente El nuevo paciente asociado a la cita.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        hash += (id != null ? id.hashCode() : 0);
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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
