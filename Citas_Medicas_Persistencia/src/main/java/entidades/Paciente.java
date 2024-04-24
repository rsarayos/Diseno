package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * Clase que representa a un paciente.
 * 
 * Un paciente tiene un identificador, nombres, apellidos, fecha de nacimiento,
 * edad, teléfono y correo electrónico.
 * 
 * La clase incluye métodos para acceder y modificar los atributos del paciente,
 * así como métodos de utilidad como equals y hashCode para comparar pacientes
 * basados en su identificador.
 * 
 */
@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    /**
     * Identificador del paciente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    
    /**
     * Nombres del paciente.
     */
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombre;
    
    /**
     * Apellido paterno del paciente.
     */
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    /**
     * Apellido materno del paciente.
     */
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;
    
    /**
     * Fecha de nacimiento del paciente.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    /**
     * Edad del paciente.
     */
    @Column(name = "edad")
    private int edad;
    
    /**
     * Teléfono del paciente.
     */
    @Column(name = "telefono", length = 10)
    private String telefono;
    
    /**
     * Correo electrónico del paciente.
     */
    @Column(name = "correo", length = 100)
    private String correo;
    
    /**
     * Lista de citas asociadas al paciente.
     */
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    private List<Cita> citas;

    /**
     * Constructor por defecto de la clase Paciente.
     */
    public Paciente() {
    }

    /**
     * Constructor que inicializa algunos atributos del paciente.
     * 
     * @param nombre Nombres del paciente.
     * @param apellidoPaterno Apellido paterno del paciente.
     * @param apellidoMaterno Apellido materno del paciente.
     * @param fechaNacimiento Fecha de nacimiento del paciente.
     * @param telefono Teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     */
    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        Calendar hoy = new GregorianCalendar();
        int edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH)
                || (hoy.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)
                && hoy.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        this.edad = edad;
    }

    /**
     * Constructor que inicializa todos los atributos del paciente.
     * 
     * @param id Identificador del paciente.
     * @param nombre Nombres del paciente.
     * @param apellidoPaterno Apellido paterno del paciente.
     * @param apellidoMaterno Apellido materno del paciente.
     * @param fechaNacimiento Fecha de nacimiento del paciente.
     * @param edad Edad del paciente.
     * @param telefono Teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     */
    public Paciente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, int edad, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Obtiene el identificador del paciente.
     * 
     * @return El identificador del paciente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del paciente.
     * 
     * @param id El nuevo identificador del paciente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del paciente.
     * 
     * @return Los nombres del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece los nombres del paciente.
     * 
     * @param nombre Los nuevos nombres del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del paciente.
     * 
     * @return El apellido paterno del paciente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del paciente.
     * 
     * @param apellidoPaterno El nuevo apellido paterno del paciente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del paciente.
     * 
     * @return El apellido materno del paciente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del paciente.
     * 
     * @param apellidoMaterno El nuevo apellido materno del paciente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente.
     * 
     * @return La fecha de nacimiento del paciente.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del paciente.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la edad del paciente.
     * 
     * @return La edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del paciente.
     * 
     * @param edad La nueva edad del paciente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el teléfono del paciente.
     * 
     * @return El teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del paciente.
     * 
     * @param telefono El nuevo teléfono del paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     * 
     * @return El correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     * 
     * @param correo El nuevo correo electrónico del paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la lista de citas asociadas al paciente.
     * 
     * @return La lista de citas asociadas al paciente.
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de citas asociadas al paciente.
     * 
     * @param citas La nueva lista de citas asociadas al paciente.
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    /**
     * Calcula el hash code del paciente.
     * 
     * @return El hash code del paciente.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si este paciente es igual a otro objeto dado.
     * 
     * @param object El objeto a comparar con este paciente.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación de cadena del paciente.
     * 
     * @return Una representación de cadena del paciente.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(nombre);
        sb.append(" ").append(apellidoPaterno);
        sb.append(" ").append(apellidoMaterno);
        return sb.toString();
    }
    
}
