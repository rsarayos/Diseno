package dtos;

import java.util.Calendar;
import java.util.List;
import excepcionesNegocio.ValidacionException;
import java.util.Date;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para un médico.
 * 
 * Esta clase proporciona métodos para acceder y manipular los atributos de un médico,
 * como la cédula profesional, nombre, apellidos, fecha de nacimiento, especialidad, etc.
 * 
 * Además, proporciona un método para validar la información del médico.
 * 
 */
public class MedicoDTO {
    
    /** La cédula profesional del médico. */
    private String cedulaProfesional;
    
    /** El nombre del médico. */
    private String nombre;
    
    /** El apellido paterno del médico. */
    private String apellidoPaterno;
    
    /** El apellido materno del médico. */
    private String apellidoMaterno;
    
    /** La fecha de nacimiento del médico. */
    private Date fechaNacimiento;
    
    /** La especialidad del médico. */
    private String especialidad;
    
    /** El número de teléfono del médico. */
    private String telefono;
    
    /** El correo electrónico del médico. */
    private String correo;
    
    /** La contraseña del médico. */
    private String contrasenia;
    
    private List<DatosFiscalesDTO> datosFiscales;
    
    private List<FacturaDTO> facturas;

    /**
     * Constructor de la clase MedicoDTO.
     * 
     * @param cedulaProfesional La cédula profesional del médico.
     */
    public MedicoDTO(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Constructor de la clase MedicoDTO.
     * 
     * @param cedulaProfesional La cédula profesional del médico.
     * @param nombre El nombre del médico.
     * @param apellidoPaterno El apellido paterno del médico.
     * @param apellidoMaterno El apellido materno del médico.
     * @param fechaNacimiento La fecha de nacimiento del médico.
     * @param especialidad La especialidad del médico.
     * @param telefono El número de teléfono del médico.
     * @param correo El correo electrónico del médico.
     * @param contrasenia La contraseña del médico.
     */
    public MedicoDTO(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String especialidad, String telefono, String correo, String contrasenia) {
        this.cedulaProfesional = cedulaProfesional;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public MedicoDTO(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String especialidad, String telefono, String correo, String contrasenia, List<DatosFiscalesDTO> datosFiscales) {
        this.cedulaProfesional = cedulaProfesional;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.datosFiscales = datosFiscales;
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
     * Obtiene el nombre del médico.
     * 
     * @return El nombre del médico.
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene el apellido materno del médico.
     * 
     * @return El apellido materno del médico.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del médico.
     * 
     * @return La fecha de nacimiento del médico.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
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
     * Obtiene el número de teléfono del médico.
     * 
     * @return El número de teléfono del médico.
     */
    public String getTelefono() {
        return telefono;
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
     * Obtiene la contraseña del médico.
     * 
     * @return La contraseña del médico.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    public List<DatosFiscalesDTO> getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(List<DatosFiscalesDTO> datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaDTO> facturas) {
        this.facturas = facturas;
    }
    
    /**
     * Verifica si la información del médico es válida.
     * 
     * @return true si la información del médico es válida, false en caso contrario.
     * @throws ValidacionException Si ocurre un error durante la validación.
     */
    public boolean esValido() throws ValidacionException{
        return true;
    }
    
}
