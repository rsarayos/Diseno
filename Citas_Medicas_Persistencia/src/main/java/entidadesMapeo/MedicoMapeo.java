package entidadesMapeo;

import entidades.DatosFiscales;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que sirve para mapear la entidad Medico dentro de una base de datos
 */
public class MedicoMapeo {
    
    /**
     * Object id correspondiente al registro en la base de datos del médico.
     */
    private ObjectId _id;
    
    /**
     * Cédula profesional del médico.
     */
    private String cedulaProfesional;
    
    /**
     * Nombres del médico.
     */
    private String nombre;
    
    /**
     * Apellido paterno del médico.
     */
    private String apellidoPaterno;
    
    /**
     * Apellido materno del médico.
     */
    private String apellidoMaterno;
    
    /**
     * Fecha de nacimiento del médico.
     */
    private Date fechaNacimiento;
    
    /**
     * Especialidad del médico.
     */
    private String especialidad;
    
    /**
     * Teléfono del médico.
     */
    private String telefono;
    
    /**
     * Correo electrónico del médico.
     */
    private String correo;
    
    /**
     * Contraseña del médico.
     */
    private String contrasenia;
    
    /**
     * Lista con los datos fiscales del medico.
     */
    private List<DatosFiscales> datosFiscales;
            
    /**
     * Constructor por defecto de la clase Medico.
     */
    public MedicoMapeo() {
    }

    /**
     * Constructor que inicializa la mayoria de los atributos del médico.
     * 
     * @param cedulaProfesional Cédula profesional del médico.
     * @param nombre Nombres del médico.
     * @param apellidoPaterno Apellido paterno del médico.
     * @param apellidoMaterno Apellido materno del médico.
     * @param fechaNacimiento Fecha de nacimiento del médico.
     * @param especialidad Especialidad del médico.
     * @param telefono Teléfono del médico.
     * @param correo Correo electrónico del médico.
     * @param contrasenia Contraseña del médico.
     */
    public MedicoMapeo(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String especialidad, String telefono, String correo, String contrasenia) {
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

    /**
     * Constructor que inicializa todos los atributos del médico.
     * 
     * @param cedulaProfesional Cédula profesional del médico.
     * @param nombre Nombres del médico.
     * @param apellidoPaterno Apellido paterno del médico.
     * @param apellidoMaterno Apellido materno del médico.
     * @param fechaNacimiento Fecha de nacimiento del médico.
     * @param especialidad Especialidad del médico.
     * @param telefono Teléfono del médico.
     * @param correo Correo electrónico del médico.
     * @param contrasenia Contraseña del médico.
     * @param datosFiscales Datos fiscales del médico.
     */
    public MedicoMapeo(String cedulaProfesional, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String especialidad, String telefono, String correo, String contrasenia, List<DatosFiscales> datosFiscales) {
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
     * Obtiene el id del médico.
     * 
     * @return El id del médico.
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el id del médico.
     * 
     * @param id el id del médico a establecer.
     */
    public void setId(ObjectId id) {
        this._id = id;
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
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del médico.
     * 
     * @param fechaNacimiento La fecha de nacimiento del médico.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
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
     * Obtiene la lista de datos fiscales del médico.
     * 
     * @return La lista de datos fiscales del médico.
     */
    public List<DatosFiscales> getDatosFiscales() {
        return datosFiscales;
    }

    /**
     * Establece la lista de datos fiscales del médico.
     * 
     * @param datosFiscales La nueva lista de datos fiscales del médico a establecer.
     */
    public void setDatosFiscales(List<DatosFiscales> datosFiscales) {
        this.datosFiscales = datosFiscales;
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
        if (!(object instanceof MedicoMapeo)) {
            return false;
        }
        MedicoMapeo other = (MedicoMapeo) object;
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
        sb.append("_id=").append(_id);
        sb.append(", cedulaProfesional=").append(cedulaProfesional);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", especialidad=").append(especialidad);
        sb.append(", telefono=").append(telefono);
        sb.append(", correo=").append(correo);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", datosFiscales=").append(datosFiscales);
        sb.append('}');
        return sb.toString();
    }
    
}
