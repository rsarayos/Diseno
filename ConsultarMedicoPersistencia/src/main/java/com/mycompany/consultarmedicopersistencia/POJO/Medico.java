/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultarmedicopersistencia.POJO;

import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad Medico.
 */
public class Medico {

    private ObjectId id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedula;
    private String especialidad;
    private String password;

    /**
     * Constructor vacío de la clase Medico.
     */
    public Medico() {
    }

    /**
     * Constructor de la clase Medico que inicializa todos los atributos.
     *
     * @param id El ID del médico.
     * @param nombre El nombre del médico.
     * @param apellidoPaterno El apellido paterno del médico.
     * @param apellidoMaterno El apellido materno del médico.
     * @param cedula La cédula del médico.
     * @param especialidad La especialidad del médico.
     * @param password La contraseña del médico.
     */
    public Medico(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String cedula, String especialidad, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.password = password;
    }

    /**
     * Constructor de la clase Medico que inicializa todos los atributos excepto
     * el ID.
     *
     * @param nombre El nombre del médico.
     * @param apellidoPaterno El apellido paterno del médico.
     * @param apellidoMaterno El apellido materno del médico.
     * @param cedula La cédula del médico.
     * @param especialidad La especialidad del médico.
     * @param password La contraseña del médico.
     */
    public Medico(String nombre, String apellidoPaterno, String apellidoMaterno, String cedula, String especialidad, String password) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.password = password;
    }

    /**
     * Método para obtener el ID del médico.
     *
     * @return El ID del médico.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el ID del médico.
     *
     * @param id El ID del médico.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el nombre del médico.
     *
     * @return El nombre del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del médico.
     *
     * @param nombre El nombre del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el apellido paterno del médico.
     *
     * @return El apellido paterno del médico.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método para establecer el apellido paterno del médico.
     *
     * @param apellidoPaterno El apellido paterno del médico.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método para obtener el apellido materno del médico.
     *
     * @return El apellido materno del médico.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método para establecer el apellido materno del médico.
     *
     * @param apellidoMaterno El apellido materno del médico.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método para obtener la cédula del médico.
     *
     * @return La cédula del médico.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método para establecer la cédula del médico.
     *
     * @param cedula La cédula del médico.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener la especialidad del médico.
     *
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Método para establecer la especialidad del médico.
     *
     * @param especialidad La especialidad del médico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Método para obtener la contraseña del médico.
     *
     * @return La contraseña del médico.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método para establecer la contraseña del médico.
     *
     * @param password La contraseña del médico.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para obtener una representación en cadena del objeto Medico.
     *
     * @return Una cadena que representa al objeto Medico.
     */
    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", cedula=" + cedula + ", especialidad=" + especialidad + ", password=" + password + '}';
    }

}
