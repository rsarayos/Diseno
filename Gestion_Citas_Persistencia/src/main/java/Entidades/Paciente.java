/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa al paciente
 * @author JESUS
 */
public class Paciente {
    //Atributo de la clase
    private ObjectId id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private int edad;
    private String telefono;
    private String correo;
    private List<ObjectId> citas;
    
    /**
     * Constructor vacio
     */
    public Paciente(){
        
    }
    
    /**
     * Constructor completo de la clase Paciente.
     * Inicializa un nuevo paciente con todos los detalles necesarios incluyendo un identificador único.
     * 
     * @param id Identificador único del paciente (ObjectId de MongoDB).
     * @param nombre Nombre del paciente.
     * @param apellidoPaterno Primer apellido del paciente.
     * @param apellidoMaterno Segundo apellido del paciente.
     * @param fechaNacimiento Fecha de nacimiento del paciente.
     * @param edad Edad del paciente.
     * @param telefono Número de teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     * @param citas Lista de identificadores de citas asociadas al paciente.
     */
    public Paciente(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int edad, String telefono, String correo, List<ObjectId> citas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.citas = citas;
    }

    /**
     * Constructor de Paciente sin ID.
     * Útil cuando el ID se genera automáticamente y no es necesario especificarlo en el momento de la creación.
     * 
     * @param nombre Nombre del paciente.
     * @param apellidoPaterno Primer apellido del paciente.
     * @param apellidoMaterno Segundo apellido del paciente.
     * @param fechaNacimiento Fecha de nacimiento del paciente.
     * @param edad Edad del paciente.
     * @param telefono Número de teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     * @param citas Lista de identificadores de citas asociadas al paciente.
     */
    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int edad, String telefono, String correo, List<ObjectId> citas) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.citas = citas;
    }

    /**
     * Devuelve el ID del paciente.
     * 
     * @return El identificador único del paciente.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del paciente.
     * 
     * @param id El nuevo identificador único a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del paciente.
     * 
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     * 
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el primer apellido del paciente.
     * 
     * @return Primer apellido del paciente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el primer apellido del paciente.
     * 
     * @param apellidoPaterno El nuevo apellido paterno a asignar.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Devuelve el segundo apellido del paciente.
     * 
     * @return Segundo apellido del paciente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el segundo apellido del paciente.
     * 
     * @param apellidoMaterno El nuevo apellido materno a asignar.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Devuelve la fecha de nacimiento del paciente.
     * 
     * @return Fecha de nacimiento del paciente.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento a asignar.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve la edad del paciente.
     * 
     * @return Edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del paciente.
     * 
     * @param edad La nueva edad a asignar al paciente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el número de teléfono del paciente.
     * 
     * @return Número de teléfono actual del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * 
     * @param telefono El nuevo número de teléfono a asignar al paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el correo electrónico del paciente.
     * 
     * @return Correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     * 
     * @param correo El nuevo correo electrónico a asignar al paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve la lista de identificadores de citas asociadas al paciente.
     * 
     * @return Lista de ObjectId representando las citas programadas para el paciente.
     */
    public List<ObjectId> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de identificadores de citas para el paciente.
     * 
     * @param citas La nueva lista de ObjectId de citas a asignar al paciente.
     */
    public void setCitas(List<ObjectId> citas) {
        this.citas = citas;
    }

    /**
     * Genera un código hash basado en el ID del paciente.
     * Utilizado principalmente en estructuras de datos que utilizan hash, como HashMap.
     * 
     * @return Código hash del paciente basado en su ID.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Determina si dos instancias de Paciente son iguales, basándose en sus identificadores.
     * Esto es esencial para evitar duplicados en colecciones.
     * 
     * @param object El objeto con el cual comparar esta instancia de Paciente.
     * @return true si los IDs son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
