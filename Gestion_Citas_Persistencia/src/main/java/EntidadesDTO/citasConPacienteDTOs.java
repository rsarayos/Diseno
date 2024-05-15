/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDTO;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class citasConPacienteDTOs {
    private String id;
    private Date fechaHora;
    private String cedulaProfesional;
    private pacienteDTOs paciente;
    private String observacion;
    private Boolean estado;

    public citasConPacienteDTOs() {
    }

    public citasConPacienteDTOs(String id, Date fechaHora, String cedulaProfesional, pacienteDTOs paciente, String observacion, Boolean estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public citasConPacienteDTOs(Date fechaHora, String cedulaProfesional, pacienteDTOs paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public pacienteDTOs getPaciente() {
        return paciente;
    }

    public void setPaciente(pacienteDTOs paciente) {
        this.paciente = paciente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
}
