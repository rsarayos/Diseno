package citas_medicas_entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    @Id
    @Column(name = "cedula_profesional", length = 8)
    private String cedulaProfesional;
    
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name = "especialidad", length = 50)
    private String especialidad;
    
    @Column(name = "rfc", length = 13)
    private String rfc;
    
    @Column(name = "telefono", length = 10)
    private String telefono;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    @Column(name = "contra", length = 50)
    private String contrasenia;
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.PERSIST)
    private List<Cita> citas;

    public Medico() {
    }

    public Medico(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String especialidad, String rfc, String telefono, String correo, String contrasenia) {
        this.cedulaProfesional = cedulaProfesional;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
        this.rfc = rfc;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaProfesional != null ? cedulaProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.cedulaProfesional == null && other.cedulaProfesional != null) || (this.cedulaProfesional != null && !this.cedulaProfesional.equals(other.cedulaProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medico{");
        sb.append("cedulaProfesional=").append(cedulaProfesional);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", especialidad=").append(especialidad);
        sb.append(", rfc=").append(rfc);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append('}');
        return sb.toString();
    }
    
}
