package dtos;

import java.util.Calendar;
import java.util.List;
import negocio_excepciones.ValidacionException;

/**
 *
 * @author alex_
 */
public class PacienteDTO {
 
    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private int edad;
    private String telefono;
    private String correo;
    private List<CitaDTO> citas;

    public PacienteDTO(Long id) {
        this.id = id;
    }

    public PacienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public PacienteDTO(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, int edad, String telefono, String correo, List<CitaDTO> citas) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.citas = citas;
    }

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
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

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public List<CitaDTO> getCitas() {
        return citas;
    }    
    
    public boolean esValido() throws ValidacionException{
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(nombres);
        sb.append(" ").append(apellidoPaterno);
        sb.append(" ").append(apellidoMaterno);
        return sb.toString();
    }
    
    
    
}
