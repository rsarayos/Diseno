/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionCitas;

import dtos.CitaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Clase para realizar las metodos
 * @author JESUS
 */
public class FGestionCita implements IGestionCita{
    //Objeto de la clase control del subsistema
    private final CGestionCIta control;
    
    /**
     * Constructor de la clase que inicializa el control
     */
    public FGestionCita(){
        control=new CGestionCIta();
    }

    /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     */
    @Override
    public List<CitaDTO> obtenerCitas(CitaDTO cita) {
        return control.obtenerCitas(cita);
    }

    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     */
    @Override
    public List<CitaDTO> consultarPorFecha(CitaDTO cita){
        return control.obtenerCitaFecha(cita);
    }

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cita Objeto CitaDTO que contiene el nombre del paciente como criterio de búsqueda.
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     */
    @Override
    public List<CitaDTO> consultarPorNombre(CitaDTO cita) {
        return control.obtenerCitaNombre(cita);
    }

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     */
    @Override
    public List<CitaDTO> consultarPorHora(CitaDTO cita)  {
        return control.obtenerCitaHora(cita);
    }

    /**
     * Cancela una cita específica.
     * 
     * @param cita Objeto CitaDTO que representa la cita a cancelar.
     * @return CitaDTO actualizada como cancelada.
     */
    @Override
    public CitaDTO cancelarCita(CitaDTO cita) {
        return control.cancelarCita(cita);
    }

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasigna CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO que contiene los nuevos detalles de la cita.
     * @return CitaDTO actualizada con la nueva información.
     */
    @Override
    public CitaDTO reasginarCita(CitaDTO citaReasigna,CitaDTO nueva)  {
        return control.reasignarCita(citaReasigna,nueva);
    }
    
    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param cita CitaDTO que contiene la fecha a verificar.
     * @return CitaDTO con el resultado de la verificación.
     */
    @Override
    public CitaDTO verificarFecha(CitaDTO cita)  {
        return control.verificarCita(cita);
    }
    
    /**
     * Método de inserccion para pruebas
     */
    @Override
    public void insertarMoco() {
        control.insertarMoco();
    }
    
    
    
}
