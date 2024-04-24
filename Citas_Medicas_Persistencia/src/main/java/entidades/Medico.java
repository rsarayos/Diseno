package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa a un médico.
 * 
 * Un médico tiene una cédula profesional, nombres, apellidos, fecha de nacimiento,
 * especialidad, RFC, teléfono, correo electrónico y una contraseña.
 * 
 * La clase incluye métodos para acceder y modificar los atributos del médico,
 * así como métodos de utilidad como equals y hashCode para comparar médicos
 * basados en su cédula profesional.
 * 
 */
@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    /**
     * Cédula profesional del médico.
     */
    @Id
    @Column(name = "cedula_profesional", length = 8)
    private String cedulaProfesional;
    
    /**
     * Nombres del médico.
     */
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombre;
    
    /**
     * Apellido paterno del médico.
     */
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    /**
     * Apellido materno del médico.
     */
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;
    
    /**
     * Fecha de nacimiento del médico.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    /**
     * Especialidad del médico.
     */
    @Column(name = "especialidad", length = 50)
    private String especialidad;
    
    /**
     * RFC del médico.
     */
    @Column(name = "rfc", length = 13)
    private String rfc;
    
    /**
     * Teléfono del médico.
     */
    @Column(name = "telefono", length = 10)
    private String telefono;
    
    /**
     * Correo electrónico del médico.
     */
    @Column(name = "correo", length = 100)
    private String correo;
    
    /**
     * Contraseña del médico.
     */
    @Column(name = "contra", length = 50)
    private String contrasenia;
    
    /**
     * Lista de citas asociadas al médico.
     */
    @OneToMany(mappedBy = "medico", cascade = CascadeType.PERSIST)
    private List<Cita> citas;

    /**
     * Constructor por defecto de la clase Medico.
     */
    public Medico() {
    }

    /**
     * Constructor que inicializa todos los atributos del médico.
     * 
     * @param cedulaProfesional Cédula profesional del médico.
     * @param nombre Nombres del médico.
     * @param apellidoPaterno Apellido paterno del médico.
     * @param apellidoMaterno Apellido materno del médico.
     * @param fechaNacimiento Fecha de nacimiento del médico.
     * @param especialidad Especialidad del médico.
     * @param rfc RFC del médico.
     * @param telefono Teléfono del médico.
     * @param correo Correo electrónico del médico.
     * @param contrasenia Contraseña del médico.
     */
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

    /**
     * Obtiene la cédula profesional del médico.
     * 
     * @return La cédula profesional del médico.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cédula profesional del médico.
     * 
     * @param cedulaProfesional La nueva cédula profesional del médico.
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Obtiene los nombres del médico.
     * 
     * @return Los nombres del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece los nombres del médico.
     * 
     * @param nombre Los nuevos nombres del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del médico.
     * 
     * @return El apellido paterno del médico.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del médico.
     * 
     * @param apellidoPaterno El nuevo apellido paterno del médico.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del médico.
     * 
     * @return El apellido materno del médico.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del médico.
     * 
     * @param apellidoMaterno El nuevo apellido materno del médico.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del médico.
     * 
     * @return La fecha de nacimiento del médico.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del médico.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del médico.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la especialidad del médico.
     * 
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del médico.
     * 
     * @param especialidad La nueva especialidad del médico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el RFC del médico.
     * 
     * @return El RFC del médico.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del médico.
     * 
     * @param rfc El nuevo RFC del médico.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el teléfono del médico.
     * 
     * @return El teléfono del médico.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del médico.
     * 
     * @param telefono El nuevo teléfono del médico.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del médico.
     * 
     * @return El correo electrónico del médico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del médico.
     * 
     * @param correo El nuevo correo electrónico del médico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del médico.
     * 
     * @return La contraseña del médico.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del médico.
     * 
     * @param contrasenia La nueva contraseña del médico.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene la lista de citas asociadas al médico.
     * 
     * @return La lista de citas asociadas al médico.
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de citas asociadas al médico.
     * 
     * @param citas La nueva lista de citas asociadas al médico.
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
   
    /**
     * Calcula el hash code del médico.
     * 
     * @return El hash code del médico.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaProfesional != null ? cedulaProfesional.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si este médico es igual a otro objeto dado.
     * 
     * @param object El objeto a comparar con este médico.
     * @return true si los objetos son iguales, false en caso contrario.
     */
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

    /**
     * Devuelve una representación de cadena del médico.
     * 
     * @return Una representación de cadena del médico.
     */
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
