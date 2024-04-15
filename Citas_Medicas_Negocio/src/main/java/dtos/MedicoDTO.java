package dtos;

import java.util.Calendar;
import java.util.List;
import negocio_excepciones.ValidacionException;

/**
 *
 * @author alex_
 */
public class MedicoDTO {
    
    private String cedulaProfesional;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private String especialidad;
    private String rfc;
    private String telefono;
    private String correo;
    private String contrasenia;
    private List<CitaDTO> citas;

    public MedicoDTO(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String especialidad, String rfc, String telefono, String correo, String contrasenia) {
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

    public MedicoDTO(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String especialidad, String rfc, String telefono, String correo, String contrasenia, List<CitaDTO> citas) {
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
        this.citas = citas;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getRfc() {
        return rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public List<CitaDTO> getCitas() {
        return citas;
    }
    
    public boolean esValido() throws ValidacionException{
        return true;
    }
    
}
