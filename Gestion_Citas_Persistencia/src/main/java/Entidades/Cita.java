/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la cita
 * @author JESUS
 */
public class Cita {
    
    //Atributos de la clase
    private ObjectId id;
    private Date fechaHora;
    private String cedulaProfesional;
    private ObjectId paciente;
    private String observacion;
    private Boolean estado;
    
    /**
     * Constructor vacio
     */
    public Cita() {
    }
    
    /**
     * Constructor con todos los parámetros.
     * Crea una nueva cita con información completa.
     * 
     * @param id Identificador único de la cita (ObjectId de MongoDB).
     * @param fechaHora Fecha y hora de la cita.
     * @param cedulaProfesional Cédula profesional del médico o profesional a cargo.
     * @param paciente Objeto paciente asociado a la cita.
     * @param observacion Observaciones relevantes sobre la cita.
     * @param estado Estado actual de la cita (por ejemplo, activo o cancelado).
     */
    public Cita(ObjectId id, Date fechaHora, String cedulaProfesional, ObjectId paciente, String observacion, Boolean estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    /**
     * Constructor sin ID.
     * Útil cuando el ID se genera automáticamente y no es necesario especificarlo.
     * 
     * @param fechaHora Fecha y hora de la cita.
     * @param cedulaProfesional Cédula profesional del médico o profesional a cargo.
     * @param paciente Objeto paciente asociado a la cita.
     * @param observacion Observaciones relevantes sobre la cita.
     * @param estado Estado actual de la cita (por ejemplo, activo o cancelado).
     */
    public Cita(Date fechaHora, String cedulaProfesional, ObjectId paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    /**
     * Devuelve el ID de la cita.
     * 
     * @return El identificador único de la cita.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID de la cita.
     * 
     * @param id El nuevo identificador único a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha y hora de la cita.
     * 
     * @return Fecha y hora programadas de la cita.
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
     * Devuelve la cédula profesional del médico o profesional a cargo de la cita.
     * 
     * @return La cédula profesional.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cédula profesional del médico o profesional a cargo.
     * 
     * @param cedulaProfesional La nueva cédula profesional a asignar.
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Devuelve el paciente asociado a la cita.
     * 
     * @return El objeto Paciente de la cita.
     */
    public ObjectId getPaciente() {
        return paciente;
    }

    /**
     * Asigna un nuevo paciente a la cita.
     * 
     * @param paciente El nuevo objeto Paciente a asignar.
     */
    public void setPaciente(ObjectId paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve las observaciones asociadas a la cita.
     * 
     * @return Las observaciones sobre la cita.
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
     * @return El estado de la cita (true o false).
     */
    public Boolean isEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la cita.
     * 
     * @param estado El nuevo estado (activo o cancelado) a asignar.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Genera un código hash basado en el ID de la cita.
     * Utilizado en estructuras que requieren un hash, como HashMap.
     * 
     * @return El código hash de la cita.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     * Determina si dos citas son iguales basándose en su ID.
     * Esto es útil para asegurar que no se introduzcan duplicados en colecciones.
     * 
     * @param object Objeto con el cual comparar esta cita.
     * @return true si los IDs son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
   
    
    
    
    
}
