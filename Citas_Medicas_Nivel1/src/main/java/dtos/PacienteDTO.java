package dtos;

/**
 *
 * @author alex_
 */
public class PacienteDTO {
 
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;

    public PacienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
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
