/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa a los pacientesDTO
 * @author JESUS
 */
public class PacienteDTO {
    
    //Atributos de la clase
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private int edad;
    private String telefono;
    private String correo;
    private List<String> citas;

    /**
     * Constructor vacío.
     * Crea una instancia de PacienteDTO sin inicializar los campos.
     */
    public PacienteDTO() {
    }

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo PacienteDTO con todos los detalles necesarios.
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
    public PacienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, int edad, String telefono, String correo, List<String> citas) {
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
     * @param edad La nueva edad a asignar.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el número de teléfono del paciente.
     * 
     * @return Número de teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * 
     * @param telefono El nuevo número de teléfono a asignar.
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
     * @param correo El nuevo correo electrónico a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve la lista de identificadores de citas asociadas al paciente.
     * 
     * @return Lista de identificadores de citas.
     */
    public List<String> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de identificadores de citas para el paciente.
     * 
     * @param citas La nueva lista de identificadores de citas a asignar.
     */
    public void setCitas(List<String> citas) {
        this.citas = citas;
    }

    /**
     * Comprueba si este objeto PacienteDTO es igual a otro objeto.
     * La igualdad se basa en la comparación de todos los campos del objeto.
     * 
     * @param obj Objeto con el que se realiza la comparación.
     * @return true si este objeto es igual al objeto especificado; false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comprueba si los objetos son exactamente el mismo.
        if (obj == null || getClass() != obj.getClass()) return false; // Comprueba si el objeto es nulo o si son de clases diferentes.
        PacienteDTO that = (PacienteDTO) obj; // Realiza un casting del objeto a PacienteDTO para comparar.
        // Compara cada campo para verificar su igualdad.
        return edad == that.edad &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(apellidoPaterno, that.apellidoPaterno) &&
               Objects.equals(apellidoMaterno, that.apellidoMaterno) &&
               Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
               Objects.equals(telefono, that.telefono) &&
               Objects.equals(correo, that.correo);
    }

    /**
     * Genera un código hash para el objeto PacienteDTO.
     * El código hash se calcula utilizando los campos del objeto para permitir una distribución uniforme en estructuras de datos basadas en hash.
     * 
     * @return Código hash calculado a partir de los atributos del paciente.
     */
    @Override
    public int hashCode() {
        // Utiliza Objects.hash para generar un hash basado en todos los campos relevantes del objeto.
        return Objects.hash(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, telefono, correo);
    }
    
    
}
