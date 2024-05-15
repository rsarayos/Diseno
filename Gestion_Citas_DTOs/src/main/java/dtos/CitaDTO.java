/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa citaDTO
 * @author JESUS
 */
public class CitaDTO {
    
    //Atributos de la clase
    private String id;
    private Date fechaHora;
    private String cedulaProfesional;
    private String paciente;
    private String observacion;
    private boolean estado;
    
    /**
     * Constructor vacío.
     * Crea una instancia de CitaDTO sin inicializar los campos.
     */
    public CitaDTO() {
    }

    /**
     * Constructor con parámetros.
     * Inicializa un nuevo CitaDTO con todos los detalles necesarios.
     * 
     * @param fechaHora Fecha y hora de la cita.
     * @param cedulaProfesional Cédula profesional del proveedor de la cita.
     * @param paciente Objeto PacienteDTO representando al paciente involucrado en la cita.
     * @param observacion Observaciones adicionales acerca de la cita.
     * @param estado Estado actual de la cita (activo o inactivo).
     */
    public CitaDTO(Date fechaHora, String cedulaProfesional, String paciente, String observacion, boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    /**
     * Devuelve la fecha y hora de la cita.
     * 
     * @return Fecha y hora de la cita.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     * 
     * @param fechaHora La nueva fecha y hora a asignar.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Devuelve la cédula profesional del proveedor de la cita.
     * 
     * @return Cédula profesional.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cédula profesional del proveedor de la cita.
     * 
     * @param cedulaProfesional La nueva cédula profesional a asignar.
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Devuelve el paciente asociado a la cita.
     * 
     * @return Objeto PacienteDTO del paciente.
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param paciente El nuevo objeto PacienteDTO a asignar.
     */
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve las observaciones relacionadas con la cita.
     * 
     * @return Observaciones de la cita.
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Añade o modifica las observaciones de la cita.
     * 
     * @param observacion Las nuevas observaciones a asignar.
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * Devuelve el estado actual de la cita.
     * 
     * @return true si la cita está activa, false si está inactiva.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la cita.
     * 
     * @param estado El nuevo estado (activo o inactivo) a asignar.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método para comparar esta instancia de CitaDTO con otra, basado en sus atributos.
     * 
     * @param obj Objeto con el que se compara.
     * @return true si todos los atributos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CitaDTO citaDTO = (CitaDTO) obj;
        return estado == citaDTO.estado &&
               Objects.equals(fechaHora, citaDTO.fechaHora) &&
               Objects.equals(cedulaProfesional, citaDTO.cedulaProfesional) &&
               Objects.equals(paciente, citaDTO.paciente) &&
               Objects.equals(observacion, citaDTO.observacion);
    }

    /**
     * Genera un código hash para el objeto CitaDTO.
     * El código hash se calcula utilizando los campos del objeto para permitir una distribución uniforme en estructuras de datos basadas en hash.
     * 
     * @return Código hash calculado a partir de los atributos de la cita.
     */
    @Override
    public int hashCode() {
        return Objects.hash(fechaHora, cedulaProfesional, paciente, observacion, estado);
    }
    
}
