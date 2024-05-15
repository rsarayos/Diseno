/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class CitasConPacienteDTO {
    private String id;
    private Date fechaHora;
    private String cedulaProfesional;
    private PacienteDTO paciente;
    private String observacion;
    private Boolean estado;

    public CitasConPacienteDTO() {
    }
    
    public CitasConPacienteDTO(Date fechaHora, String cedulaProfesional, PacienteDTO paciente, String observacion, Boolean estado) {
        this.fechaHora = fechaHora;
        this.cedulaProfesional = cedulaProfesional;
        this.paciente = paciente;
        this.observacion = observacion;
        this.estado = estado;
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

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
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
