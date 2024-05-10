package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

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
public class Paciente implements Serializable {

    /**
     * Identificador del paciente.
     */
    private ObjectId _id;
    
    /**
     * Nombres del paciente.
     */
    private String nombre;
    
    /**
     * Apellido paterno del paciente.
     */
    private String apellidoPaterno;
    
    /**
     * Apellido materno del paciente.
     */
    private String apellidoMaterno;
    
    /**
     * Fecha de nacimiento del paciente.
     */
    private Date fechaNacimiento;
    
    /**
     * Edad del paciente.
     */
    private int edad;
    
    /**
     * Teléfono del paciente.
     */
    private String telefono;
    
    /**
     * Correo electrónico del paciente.
     */
    private String correo;
    
    private List<DatosFiscales> datosFiscales;

    /**
     * Constructor por defecto de la clase Paciente.
     */
    public Paciente() {
    }

    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int edad, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Paciente(ObjectId _id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int edad, String telefono, String correo, List<DatosFiscales> datosFiscales) {
        this._id = _id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.datosFiscales = datosFiscales;
    }
    
    

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public List<DatosFiscales> getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(List<DatosFiscales> datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    /**
     * Calcula el hash code del paciente.
     * 
     * @return El hash code del paciente.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
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
        sb.append("Paciente{");
        sb.append("_id=").append(_id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", edad=").append(edad);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append(", datosFiscales=").append(datosFiscales);
        sb.append('}');
        return sb.toString();
    }

}
