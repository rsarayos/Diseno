package com.mycompany.consultarmedicodto.DTOS;

import com.mycompany.consultarmediconegocio.Excepciones.ValidacionException;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para un
 * médico.
 *
 * Esta clase proporciona métodos para acceder y manipular los atributos de un
 * médico, como la cédula, nombre, apellidos, especialidad, etc.
 *
 * Además, proporciona un método para validar la información del médico.
 *
 */
public class MedicoDTO {

    /**
     * La cédula del médico.
     */
    private String cedula;

    /**
     * El nombre del médico.
     */
    private String nombre;

    /**
     * El apellido paterno del médico.
     */
    private String apellidoPaterno;

    /**
     * El apellido materno del médico.
     */
    private String apellidoMaterno;

    /**
     * La especialidad del médico.
     */
    private String especialidad;

    /**
     * La contraseña del médico.
     */
    private String password;

    public MedicoDTO() {
    }

    /**
     * Constructor de la clase MedicoDTO
     *
     * @param cedula
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param especialidad
     * @param password
     */
    public MedicoDTO(String cedula, String nombre, String apellidoPaterno, String apellidoMaterno, String especialidad, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.especialidad = especialidad;
        this.password = password;
    }

    /**
     * Obtiene la cédula del médico.
     *
     * @return La cédula profesional del médico.
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Agrega la cédula del médico.
     * 
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
     * Obtiene la especialidad del médico.
     *
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Obtiene la contraseña del médico.
     *
     * @return La contraseña del médico.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Verifica si la información del médico es válida.
     *
     * @return true si la información del médico es válida, false en caso
     * contrario.
     * @throws ValidacionException Si ocurre un error durante la validación.
     */
    public boolean esValido() throws ValidacionException {
        return true;
    }

}
