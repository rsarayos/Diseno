package dtos;

import auxiliares.Validadores;
import java.util.Calendar;
import java.util.List;
import negocio_excepciones.ValidacionException;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para un paciente.
 * 
 * Esta clase proporciona métodos para acceder y manipular los atributos de un paciente,
 * como el ID, nombres, apellidos, fecha de nacimiento, edad, teléfono, correo electrónico, etc.
 * 
 * Además, proporciona un método para validar la información del paciente.
 * 
 */
public class PacienteDTO {
    
    /** El ID del paciente. */
    private Long id;
    
    /** Los nombres del paciente. */
    private String nombres;
    
    /** El apellido paterno del paciente. */
    private String apellidoPaterno;
    
    /** El apellido materno del paciente. */
    private String apellidoMaterno;
    
    /** La fecha de nacimiento del paciente. */
    private Calendar fechaNacimiento;
    
    /** La edad del paciente. */
    private int edad;
    
    /** El número de teléfono del paciente. */
    private String telefono;
    
    /** El correo electrónico del paciente. */
    private String correo;
    
    /** La lista de citas del paciente. */
    private List<CitaDTO> citas;

    /**
     * Constructor de la clase PacienteDTO.
     * 
     * @param id El ID del paciente.
     */
    public PacienteDTO(Long id) {
        this.id = id;
    }

    /**
     * Constructor de la clase PacienteDTO.
     * 
     * @param nombres Los nombres del paciente.
     * @param apellidoPaterno El apellido paterno del paciente.
     * @param apellidoMaterno El apellido materno del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param correo El correo electrónico del paciente.
     */
    public PacienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Constructor de la clase PacienteDTO.
     * 
     * @param id El ID del paciente.
     * @param nombres Los nombres del paciente.
     * @param apellidoPaterno El apellido paterno del paciente.
     * @param apellidoMaterno El apellido materno del paciente.
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param edad La edad del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param correo El correo electrónico del paciente.
     * @param citas La lista de citas del paciente.
     */
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

    /**
     * Obtiene el ID del paciente.
     * 
     * @return El ID del paciente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene los nombres del paciente.
     * 
     * @return Los nombres del paciente.
     */
    public String getNombres() {
        return nombres;
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
     * Obtiene el apellido materno del paciente.
     * 
     * @return El apellido materno del paciente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
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
     * Obtiene la edad del paciente.
     * 
     * @return La edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el número de teléfono del paciente.
     * 
     * @return El número de teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
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
     * Obtiene la lista de citas del paciente.
     * 
     * @return La lista de citas del paciente.
     */
    public List<CitaDTO> getCitas() {
        return citas;
    }    
    
    /**
     * Verifica si la información del paciente es válida.
     * 
     * @return true si la información del paciente es válida, false en caso contrario.
     * @throws ValidacionException Si ocurre un error durante la validación.
     */
    public boolean esValido() throws ValidacionException {
        Validadores validador = new Validadores();
        if (!validador.validaNombre(nombres)) {
            return false;
        }
        if (!validador.validaApellidos(apellidoPaterno)) {
            return false;
        }
        if (!validador.validaApellidos(apellidoMaterno)) {
            return false;
        }
        if (!validador.validaTelefono(telefono)) {
            return false;
        }
        if (!validador.validaEmail(correo)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de este objeto PacienteDTO.
     * 
     * @return Una cadena que representa este objeto PacienteDTO.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(nombres);
        sb.append(" ").append(apellidoPaterno);
        sb.append(" ").append(apellidoMaterno);
        return sb.toString();
    }
    
    
    
}
