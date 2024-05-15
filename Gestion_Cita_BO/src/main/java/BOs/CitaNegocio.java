/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import convertidores.convertidorCita;
import convertidores.convertidorCitasConPaciente;
import convertidores.convertidorPaciente;
import interfaces.ICitaDAO;
import DAOs.CitaDAO;
import dtos.CitaDTO;
import dtos.CitasConPacienteDTO;
import EntidadesDTO.citasConPacienteDTOs;
import EntidadesDTO.citaDTOs;
import dtos.PacienteDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de cita negocio
 * @author JESUS
 */
public class CitaNegocio implements ICitaNegocio{
    
    //Variables de la clase
    private final ICitaDAO citaDAO;
    private convertidorCita convi;
    private convertidorCitasConPaciente conviLis;
    private convertidorPaciente conviP;
    static final Logger logger = Logger.getLogger(CitaNegocio.class.getName());
    
    /**
     * Metodo contructor para iniciar variables
     */
    public CitaNegocio(){
        this.citaDAO=new CitaDAO();
        this.convi=new convertidorCita();
        this.conviLis= new convertidorCitasConPaciente();
        this.conviP = new convertidorPaciente();
    }

    /**
     * Obtiene una lista de citas basada en los criterios especificados en el objeto CitaDTO.
     * 
     * @param cita Objeto CitaDTO con criterios de búsqueda.
     * @return Lista de CitaDTO que cumplen con los criterios.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<CitasConPacienteDTO> obtenerCitas(CitaDTO cita) throws NegocioException {
        List<CitasConPacienteDTO> citas=new ArrayList<>();
        List<citasConPacienteDTOs> citasC=null;
        try {
            citasC=citaDAO.obtenerCitas(convi.convertidorDTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas");
            throw new NegocioException("Error al obtener las citas", e);
        }
        if (citasC!=null) {
            for (citasConPacienteDTOs listaCita:citasC) {
                citas.add(conviLis.convertidorEntidadADTO(listaCita));
            }
        }
        return citas;
    }

    /**
     * Consulta las citas por fecha específica.
     * 
     * @param cita Objeto CitaDTO que contiene la fecha de interés.
     * @return Lista de CitaDTO programadas para esa fecha.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<CitasConPacienteDTO> consultarPorFecha(CitaDTO cita) throws NegocioException {
        List<CitasConPacienteDTO> citas=new ArrayList<>();
        List<citasConPacienteDTOs> citasC=null;
        try {
            citasC=citaDAO.consularPorFecha(convi.convertidorDTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por fecha");
            throw new NegocioException("Error al obtener las citas por fecha", e);
        }
        if (citasC!=null) {
            for (citasConPacienteDTOs listaCita: citasC) {
                citas.add(conviLis.convertidorEntidadADTO(listaCita));
            }
        }
        return citas;
    }

    /**
     * Consulta las citas por nombre del paciente.
     * 
     * @param cita Objeto CitaDTO que contiene el nombre del paciente como criterio de búsqueda.
     * @return Lista de CitaDTO asociadas al nombre del paciente especificado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<CitasConPacienteDTO> consultarPorNombre(CitaDTO cita,PacienteDTO paciente) throws NegocioException {
        List<CitasConPacienteDTO> citas=new ArrayList<>();
        List<citasConPacienteDTOs> citasC=null;
        try {
            citasC=citaDAO.consultarPorNombre(convi.convertidorDTOAEntidad(cita),conviP.convertirDTOAEntidad(paciente));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por nombre");
            throw new NegocioException("Error al obtener las citas por nombre", e);
        }
        if (citasC!=null) {
            for (citasConPacienteDTOs listaCita: citasC) {
                citas.add(conviLis.convertidorEntidadADTO(listaCita));
            }
        }
        return citas;
    }

    /**
     * Consulta las citas por hora específica.
     * 
     * @param cita Objeto CitaDTO que contiene la hora de interés.
     * @return Lista de CitaDTO programadas para esa hora específica.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    @Override
    public List<CitasConPacienteDTO> consultarPorHora(CitaDTO cita) throws NegocioException {
        List<CitasConPacienteDTO> citas=new ArrayList<>();
        List<citasConPacienteDTOs> citasC=null;
        try {
            citasC=citaDAO.consultaPorHora(convi.convertidorDTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al obtener citas por hora");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        if (citasC!=null) {
            for (citasConPacienteDTOs listaCita:citasC) {
                citas.add(conviLis.convertidorEntidadADTO(listaCita));
            }
        }
        return citas;
    }

    /**
     * Cancela una cita específica.
     * 
     * @param cita Objeto CitaDTO que representa la cita a cancelar.
     * @return CitaDTO actualizada como cancelada.
     * @throws NegocioException Si ocurre un error durante la operación de cancelación.
     */
    @Override
    public CitaDTO cancelarCita(CitaDTO cita) throws NegocioException {
        citaDTOs persistencia=null;
        try {
            persistencia=citaDAO.cancelarCita(convi.convertidorDTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al cancelar cita");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        return convi.convertidorEntidadADTO(persistencia);
    }

    /**
     * Reasigna una cita a una nueva fecha u hora.
     * 
     * @param citaReasigna CitaDTO original que se desea reasignar.
     * @param nueva CitaDTO que contiene los nuevos detalles de la cita.
     * @return CitaDTO actualizada con la nueva información.
     * @throws NegocioException Si ocurre un error durante el proceso de reasignación.
     */
    @Override
    public CitaDTO reasginarCita(CitaDTO citaReasigna,CitaDTO nueva) throws NegocioException {
       citaDTOs persistencia=null;
        try {
            persistencia=citaDAO.ReasignarCita(convi.convertidorDTOAEntidad(citaReasigna), convi.convertidorDTOAEntidad(nueva));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al cancelar cita");
            throw new NegocioException("Error al obtener las citas por hora", e);
        }
        return convi.convertidorEntidadADTO(persistencia);
    }

    /**
     * Verifica la disponibilidad de una fecha para programar una cita.
     * 
     * @param cita CitaDTO que contiene la fecha a verificar.
     * @return CitaDTO con el resultado de la verificación.
     * @throws NegocioException Si ocurre un error al verificar la fecha.
     */
    @Override
    public CitaDTO verificarFecha(CitaDTO cita) throws NegocioException {
        citaDTOs persistencia=null;
        try {
            persistencia=citaDAO.verificaFecha(convi.convertidorDTOAEntidad(cita));
        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error al verificar cita");
            throw new NegocioException("Error al verificar citia", e);
        }
        if (persistencia!=null) {
            return convi.convertidorEntidadADTO(persistencia);
        }else{
            return null;
        }
    }

    /**
     * Método inserccion para pruebas
     * 
     * @throws NegocioException Si se define que debe simular un error de negocio.
     */
    @Override
    public void insertarMoco() throws NegocioException {
        try {
            citaDAO.inserccionMoco();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al insertar");
            throw new NegocioException("Error al onsertar moco", e);
        }
    }
    
}
